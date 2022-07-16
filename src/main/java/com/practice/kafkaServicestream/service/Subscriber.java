package com.practice.kafkaServicestream.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.kafkaServicestream.configuration.KafkaStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding(KafkaStreams.class)
@ConditionalOnProperty("consumer.enabled")
@Slf4j
public class Subscriber {

    private final ObjectMapper objectMapper;

    private final KafkaStreams kafkaStreams;

    @Autowired
    public Subscriber(ObjectMapper objectMapper, KafkaStreams kafkaStreams) {
        this.objectMapper = objectMapper;
        this.kafkaStreams = kafkaStreams;
    }

    @StreamListener(value = KafkaStreams.INPUT_TEST)
    public void getMessage(Message<String> message) {
        log.info("Message consumed : " + message.getPayload());
    }
}
