package hu.imosonyi.bvtech.analyzer.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures {@link Queue} bean.
 *
 * @author István Mosonyi
 */
@Configuration
public class JmsConfig {

    @Bean
    public Queue queue () {
        return new ActiveMQQueue("bvtech-db");
    }

}
