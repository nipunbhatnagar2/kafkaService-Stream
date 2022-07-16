package com.practice.kafkaServicestream.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import java.util.Map;

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.cloud.stream.kafka.binder")
public class KafkaConfiguration {
    private Map<String, Message<String>> configuration;
}
