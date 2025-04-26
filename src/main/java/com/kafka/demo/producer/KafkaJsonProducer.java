package com.kafka.demo.producer;

import com.kafka.demo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {
    @Value("${topic.name}")
    private String topicName;

    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMsg(Student student){
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();
        log.info("Sending json message to topic " + topicName + " :: " + student.toString());
        kafkaTemplate.send(message);
    }
}
