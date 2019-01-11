package com.example.demo.mq.ActiveMQ;

import com.example.demo.mq.ActiveMQ.topic.ActiveProducerTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicSampleActiveMqTests {

    /**
     * 注入消息生产者
     */
    @Autowired
    private ActiveProducerTopic activeProducerTopic;

    @Test
    public void sendSimpleTopicMessage() {
        this.activeProducerTopic.sendTopic("Test Topic message");
    }
}
