package com.example.demo.mq.ActiveMQ.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer2 {

    // @JmsListener(destination = "neo.queue")，表示此方法监控了名为 neo.queue 的队列
    @JmsListener(destination = "neo.queue", containerFactory = "queueListenerFactory")
    public void receiveQueue(String text){
        System.out.println("Consumer2 queue msg : "+text);
    }
}
