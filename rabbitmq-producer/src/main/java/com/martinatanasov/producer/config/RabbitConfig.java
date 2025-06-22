package com.martinatanasov.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.queue}")
    private String queue;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public Queue myQueue() {
        return new Queue(queue, true);
    }

    @Bean
    public TopicExchange myExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding binding(Queue myQueue, TopicExchange myExchange) {
        return BindingBuilder.bind(myQueue).to(myExchange).with(routingKey);
    }
}
