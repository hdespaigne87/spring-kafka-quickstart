package org.example.hdr.spring.kafka.quickstart;

import java.util.concurrent.TimeUnit;
import org.example.hdr.spring.kafka.quickstart.consumer.ExampleMessageListener;
import org.example.hdr.spring.kafka.quickstart.producer.ExampleMessageSender;
import org.example.hdr.spring.kafka.quickstart.topics.KafkaTopicConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ExampleMessageSender sender = context.getBean(ExampleMessageSender.class);
        ExampleMessageListener listener = context.getBean(ExampleMessageListener.class);

        sender.sendMessage(KafkaTopicConfig.TOPIC_SPRING_TEST_1, "Hello, World 1!");
        listener.getLatch().await(5, TimeUnit.SECONDS);

        context.close();
    }
}
