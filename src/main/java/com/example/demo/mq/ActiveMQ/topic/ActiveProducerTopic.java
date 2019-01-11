package com.example.demo.mq.ActiveMQ.topic;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

@Component
public class ActiveProducerTopic {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Topic topic;

    public void sendTopic(String msg){
        System.out.println("send topic msg : "+msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
