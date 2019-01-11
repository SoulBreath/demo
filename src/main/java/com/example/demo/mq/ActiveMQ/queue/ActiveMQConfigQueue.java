package com.example.demo.mq.ActiveMQ.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class ActiveMQConfigQueue {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("neo.queue");
    }
}
