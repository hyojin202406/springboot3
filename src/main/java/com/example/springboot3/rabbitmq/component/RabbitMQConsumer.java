package com.example.springboot3.rabbitmq.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "ndms")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
        // 여기서 메시지 처리 로직을 작성합니다.
    }
}