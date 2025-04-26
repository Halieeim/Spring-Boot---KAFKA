package com.kafka.demo.controller;

import com.kafka.demo.payload.Student;
import com.kafka.demo.producer.KafkaJsonProducer;
import com.kafka.demo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MsgController {
    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/sendmsg")
    public ResponseEntity<String> sendMsg(@RequestBody String msg){
        kafkaProducer.sendMsg(msg);
        return ResponseEntity.ok("Message Queued successfully.");
    }

    @PostMapping("/sendjsonmsg")
    public ResponseEntity<String> sendMsg(@RequestBody Student student){
        kafkaJsonProducer.sendMsg(student);
        return ResponseEntity.ok("Json Message Queued successfully.");
    }
}
