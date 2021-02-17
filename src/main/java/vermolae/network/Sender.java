package vermolae.network;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import vermolae.model.dto.DataChangeNotification;
import vermolae.model.dto.Tariff.TariffViewForm;
import vermolae.model.entity.Option;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;


@Component
@AllArgsConstructor
public class Sender {

    private final JmsTemplate jmsTemplate;

    private final Queue queue;

    private final JsonParser jsonParser;

    public void notifyClients(TariffViewForm tariffViewForm) {
        final DataChangeNotification message = new DataChangeNotification();
//        jmsTemplate.convertAndSend(queue, message);
        jmsTemplate.send(queue, new MessageCreator() {
            @SneakyThrows
            @Override
            public Message createMessage(Session session) throws JMSException {
                String textMessage = jsonParser.writeToJSON(tariffViewForm);
                return session.createTextMessage(textMessage);
            }
        });
    }

    public String receiveAck() {
        return (String) jmsTemplate.receiveAndConvert("ackQueue");
    }
}