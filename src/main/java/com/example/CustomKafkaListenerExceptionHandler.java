package com.example;

import io.micronaut.configuration.kafka.exceptions.DefaultKafkaListenerExceptionHandler;
import io.micronaut.configuration.kafka.exceptions.KafkaListenerException;
import io.micronaut.configuration.kafka.exceptions.KafkaListenerExceptionHandler;
import io.micronaut.context.annotation.Replaces;
import jakarta.inject.Singleton;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Optional;

@Singleton
@Replaces(DefaultKafkaListenerExceptionHandler.class)
public class CustomKafkaListenerExceptionHandler implements KafkaListenerExceptionHandler {
  @Override
  public void handle(KafkaListenerException exception) {

    Optional<ConsumerRecord<?, ?>> consumerRecord = exception.getConsumerRecord();
    if (consumerRecord.isPresent()) {
      //TODO Handle the consumer record
    }
  }
}

