package com.example;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.KafkaKey;
import io.micronaut.configuration.kafka.annotation.Topic;

@KafkaClient
public interface OrderPlacedProducer {

  @Topic("order-placed")
  void sendProduct(@KafkaKey String customer,
                   OrderEvent orderEvent);

}




