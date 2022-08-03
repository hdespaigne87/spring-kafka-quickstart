package org.example.hdr.spring.kafka.quickstart.topics;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC_SPRING_TEST_1 = "spring-test1";
    public static final String TOPIC_SPRING_TEST_2 = "spring-test2";

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicSpringTest1() {
        return new NewTopic(TOPIC_SPRING_TEST_1, 1, (short) 1);
    }

    @Bean
    public NewTopic topicSpringTest2() {
        return new NewTopic(TOPIC_SPRING_TEST_2, 1, (short) 1);
    }
}
