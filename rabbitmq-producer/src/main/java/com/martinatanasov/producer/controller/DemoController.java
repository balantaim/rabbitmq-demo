package com.martinatanasov.producer.controller;


import com.martinatanasov.producer.model.FatalMessage;
import com.martinatanasov.producer.service.MessageEventPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DemoController {

    private final MessageEventPublisher messageEventPublisher;

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        // Create new message object
        FatalMessage event = new FatalMessage(UUID.randomUUID().toString(), message);
        log.info("Message to RabbitMQ: {}", event);
        // Sent the object to the consumer
        messageEventPublisher.publish(event);

        return ResponseEntity.ok("Message sent to RabbitMQ: " + message);
    }

}
