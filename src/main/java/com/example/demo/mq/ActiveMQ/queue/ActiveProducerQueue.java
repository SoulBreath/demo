package com.example.demo.mq.ActiveMQ.queue;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

@Component
public class ActiveProducerQueue {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Resource
    private Queue queue;

    public void sendQueue(String msg){
        System.out.println("send queue msg : "+msg);
        this.jmsMessagingTemplate.convertAndSend(this.queue,msg);
    }
}
