package com.practice.kafkaServicestream.configuration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaStreams {

    String INPUT_TEST = "input_test";
    String OUTPUT_TEST = "output_test";

    @Input(INPUT_TEST)
    SubscribableChannel input_test();

    @Output(OUTPUT_TEST)
    MessageChannel output_test();
}
