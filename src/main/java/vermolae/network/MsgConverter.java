package vermolae.network;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import vermolae.model.dto.DataChangeNotification;

import javax.jms.*;

public class MsgConverter implements MessageConverter {

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
        DataChangeNotification notification = (DataChangeNotification) object;
       TextMessage message1= session.createTextMessage();
       message1.setText("TEST TEXT");
        return message1;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        MapMessage mapMessage = (MapMessage) message;
        return new DataChangeNotification(mapMessage.getString("sender"));
    }
}
