package com.example.demo.mq.ActiveMQ;

import com.example.demo.mq.ActiveMQ.queue.ActiveProducerQueue;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueueSampleActiveMQTests {

    /**
     * 注入ActiveProducer
     */
    @Autowired
    private ActiveProducerQueue activeProducerQueue;

    /**
     * OutputCapture 是 Spring Boot 提供的一个测试类，
     * 它能捕获 System.out 和 System.err 的输出，我们可以利用这个特性来判断程序中的输出是否执行。
     */
    @Rule
    public OutputCapture outputCapture = new OutputCapture();


    @Test
    public void send100QueueMessage() throws InterruptedException {

        for(int i=0; i<100; i++) {
            this.activeProducerQueue.sendQueue("Test queue message : "+i);
        }
        Thread.sleep(1000);
    }

}
