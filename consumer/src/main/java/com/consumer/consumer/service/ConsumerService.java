package com.consumer.consumer.service;

import com.consumer.consumer.model.Consumer;
import com.consumer.consumer.repository.ConsumerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;
    private final WebClient webClient;

    public ConsumerService(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://localhost:8080/api/v1").build();
    }

    public Flux<Consumer> getData() {
        log.info("GET /list");
        return webClient
                .get()
                .uri("/list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, error ->
                        Mono.error(new RuntimeException("" +
                        "bad request")))
                .bodyToFlux(Consumer.class)
                .flatMap(consumer -> Mono.just(consumerRepository.save(consumer)));

    }


}
