package org.example.hdr.spring.kafka.quickstart.consumer;

import java.util.concurrent.CountDownLatch;
import lombok.Getter;
import org.example.hdr.spring.kafka.quickstart.topics.KafkaTopicConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ExampleMessageListener {

    @Getter
    private CountDownLatch latch = new CountDownLatch(3);

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_SPRING_TEST_1, groupId = KafkaConsumerConfig.CUSTOM_GROUP_ID_1)
    public void listenGroup1(String message) {
        System.out.println(String.format("Received Message in group %s: %s",
                KafkaConsumerConfig.CUSTOM_GROUP_ID_1, message));
        latch.countDown();
    }

    @KafkaListener(topics = KafkaTopicConfig.TOPIC_SPRING_TEST_1, groupId = KafkaConsumerConfig.CUSTOM_GROUP_ID_2)
    public void listenGroup2(String message) {
        System.out.println(String.format("Received Message in group %s: %s",
                KafkaConsumerConfig.CUSTOM_GROUP_ID_2, message));
        latch.countDown();
    }
}
