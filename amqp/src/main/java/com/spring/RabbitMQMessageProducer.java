package com.spring;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payload, String exchange, String routeKey) {
        log.info("Publish to {} using routingkey {}. payload {} ", exchange, routeKey, payload);
        amqpTemplate.convertAndSend(exchange, routeKey, payload);
        log.info("Published to {} using routingkey {}. payload {} ", exchange, routeKey, payload);
    }

}
