package com.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    @RabbitListener(queues = {"${rabbitmq.queues.admin-messages}"})
    public void consumeJsonMessage(String data) {
        LOGGER.info(String.format("Received message -> %s", data));
    }

}
