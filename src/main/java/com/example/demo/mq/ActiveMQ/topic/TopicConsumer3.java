package com.example.demo.mq.ActiveMQ.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer3 {

    // @JmsListener(destination = "active.topic")，表示此方法监控了名为 neo.queue 的队列
    @JmsListener(destination = "neo.topic", containerFactory = "topicListenerFactory")
    public void receiveTopic(String text){
        System.out.println("Consumer3 queue msg : "+text);
    }
}
