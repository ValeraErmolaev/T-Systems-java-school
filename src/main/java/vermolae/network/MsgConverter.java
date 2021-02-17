package vermolae.network;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import vermolae.model.dto.DataChangeNotification;

import javax.jms.*;

public class MsgConverter implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        DataChangeNotification notification = (DataChangeNotification) object;
//        MapMessage message = session.createMapMessage();
       TextMessage message1= session.createTextMessage();
       message1.setText("TEST TEXT");
//        message.setString("key", notification.getKey());
//        message.setString("sender", notification.getSender());
        return message1;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage mapMessage = (MapMessage) message;
        return new DataChangeNotification(mapMessage.getString("sender"));
    }
}
