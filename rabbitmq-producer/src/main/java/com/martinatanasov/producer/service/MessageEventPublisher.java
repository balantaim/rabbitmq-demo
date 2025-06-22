package com.martinatanasov.producer.service;

import com.martinatanasov.producer.model.FatalMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MessageEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    public void publish(FatalMessage event) {
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
    }
}
