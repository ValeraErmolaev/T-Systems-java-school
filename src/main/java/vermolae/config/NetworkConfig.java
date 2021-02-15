package vermolae.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.apache.activemq.ActiveMQConnectionFactory;
import vermolae.network.MsgConverter;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

@Configuration
@EnableJms
public class NetworkConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    Queue queue() {
        return new ActiveMQQueue("QUEUE");
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setMessageConverter(new MsgConverter());
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate(connectionFactory());
        template.setConnectionFactory(connectionFactory());
        return template;
    }
}