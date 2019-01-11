package com.example.demo.mq.ActiveMQ.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;


@Configuration
public class ActiveMQConfigTopic {

    @Bean
    public Topic activeMQTempTopic(){
        return new ActiveMQTopic("neo.topic");
    }
}
