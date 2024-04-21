package com.spring.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class NotificationConfig {

    //    @Value("${rabbitmq.template.exchange}")
    private final String internalExchange = "internal.exchange";

    //    @Value("${rabbitmq.template.default-receive-queue}")
    private final String notificationQueues = "notification.queue";

    //    @Value("${rabbitmq.template.routing-key}")
    private final String routingKeys = "internal.notification.routing.key";

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(this.internalExchange);
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(this.notificationQueues);
    }

    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(notificationQueue())
                .to(internalTopicExchange()).with(this.routingKeys);
    }
}
