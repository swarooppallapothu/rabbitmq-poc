package com.producer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchanges.admin-messages}")
    private String adminMessagesExchange;

    public void publishToAdminMessages(String data) {
        Message mqMessage = new Message(data.getBytes());
        amqpTemplate.convertAndSend(adminMessagesExchange, "test", mqMessage);
    }


}
