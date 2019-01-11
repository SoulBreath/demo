package com.example.demo.mq.ActiveMQ.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer1 {

    // @JmsListener(destination = "active.queue")，表示此方法监控了名为 neo.queue 的队列
    @JmsListener(destination = "neo.queue", containerFactory = "queueListenerFactory")
    public void receiveQueue(String text){
        System.out.println("Consumer1 queue msg : "+text);
    }
}
