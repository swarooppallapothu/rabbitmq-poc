package com.producer.controller;

import com.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/publish")
    public ResponseEntity<Void> publishMessage(@RequestBody String data) {
        producerService.publishToAdminMessages(data);
        return ResponseEntity.ok().build();
    }


}
