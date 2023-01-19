package com.consumer.consumer.controller;

import com.consumer.consumer.model.Consumer;
import com.consumer.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Consumer> getConsumers() {
        return consumerService.getData();
    }
}
