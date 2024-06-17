package com.example.springboot3.rabbitmq.component;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProducerConfig {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducerConfig(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Bean
    public Queue queue() {
        return new Queue("queue_name");
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("queue_name", message);
        System.out.println("Message sent: " + message);
    }
}
