package com.kafka.demo.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMsg(String msg){
        log.info("Sending message to topic 'push-notification-events-spring':: " + msg);
        kafkaTemplate.send("push-notification-events-spring", msg);
    }
}
