package com.kafka.demo.consumer;

import com.kafka.demo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumer {
    @Value("${topic.name}")
    private String topicName;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public String consumeMsg(Student student){
        log.info("consumed msg successfully from topic " + topicName + " :: " + student.toString());
        return student.toString();
    }
}
