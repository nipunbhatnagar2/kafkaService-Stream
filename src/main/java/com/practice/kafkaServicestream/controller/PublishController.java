package com.practice.kafkaServicestream.controller;

import com.practice.kafkaServicestream.service.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class PublishController {

    @Autowired
    private Publisher publisher;

    @GetMapping(value = "/producer/{message}")
    public String publish(@PathVariable(name = "message", required = true) String message) {

        publisher.publish(message, "header");
        return "Message published : " + message;
    }
}
