package com.kafka.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${topic.name}")
    private String topicName;

    @Bean
    public NewTopic pushNotificationTopic(){
        return TopicBuilder
                .name(topicName)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
