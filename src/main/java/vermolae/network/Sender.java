package vermolae.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import vermolae.model.dto.DataChangeNotification;

import javax.jms.Queue;


@Component
public class Sender {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    public void notifyClients() {
        final DataChangeNotification message = new DataChangeNotification();
        jmsTemplate.convertAndSend(queue, message);
    }

    public String receiveAck() {
        return (String) jmsTemplate.receiveAndConvert("ackQueue");
    }
}