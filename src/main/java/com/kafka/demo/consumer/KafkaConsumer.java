package com.kafka.demo.consumer;

import com.kafka.demo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class KafkaConsumer {
//    @KafkaListener(topics = "push-notification-events-spring", groupId = "${spring.kafka.consumer.group-id}")
//    public String consumeMsg(String msg){
//        log.info("consumed msg successfully from topic push-notification-events-spring :: " + msg);
//        return msg;
//    }

    @KafkaListener(topics = "push-notification-events-spring", groupId = "${spring.kafka.consumer.group-id}")
    public String consumeMsg(Student student){
        log.info("consumed msg successfully from topic push-notification-events-spring :: " + student.toString());
        return student.toString();
    }
}
