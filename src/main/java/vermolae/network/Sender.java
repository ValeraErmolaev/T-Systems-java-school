package vermolae.network;

import lombok.AllArgsConstructor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import vermolae.crud.service.impl.TariffServiceImpl;
import vermolae.model.dto.DataChangeNotification;
import vermolae.model.dto.Tariff.TariffForStand;

import javax.jms.Queue;
import java.io.IOException;


@Component
@AllArgsConstructor
public class Sender {

    private final JmsTemplate jmsTemplate;

    private final Queue queue;

    private final JsonParser jsonParser;

    private static Logger logger = LogManager.getLogger(TariffServiceImpl.class);

    public void sendMessageToStand(TariffForStand tariff) {
        final DataChangeNotification message = new DataChangeNotification();
        jmsTemplate.send(queue, session -> {
            String textMessage = null;
            try {
                textMessage = jsonParser.writeToJSON(tariff);
            } catch (IOException e) {
                logger.trace(e);
//                e.printStackTrace();
            }
            return session.createTextMessage(textMessage);
        });
    }

//    public String receiveAck() {
//        return (String) jmsTemplate.receiveAndConvert("ackQueue");
//    }
}