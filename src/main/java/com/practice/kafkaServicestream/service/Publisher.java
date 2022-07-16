package com.practice.kafkaServicestream.service;

import com.practice.kafkaServicestream.configuration.KafkaStreams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

@Configuration
@RequiredArgsConstructor
@EnableBinding(KafkaStreams.class)
@Slf4j
public class Publisher {

    private final KafkaStreams kafkaStreams;

    public void publish(String message, String header){
        MessageChannel messageChannel = kafkaStreams.output_test();
        messageChannel.send(MessageBuilder
                .withPayload(message)
                .setHeader("header", header)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON_VALUE)
                .build());

        log.info("Published message");
    }
}
