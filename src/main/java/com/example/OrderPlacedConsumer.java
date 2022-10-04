package com.example;

import io.micronaut.configuration.kafka.annotation.*;
import io.micronaut.messaging.Acknowledgement;
import io.micronaut.messaging.annotation.SendTo;

import static io.micronaut.configuration.kafka.annotation.ErrorStrategyValue.RETRY_ON_ERROR;

@KafkaListener(
    offsetStrategy = OffsetStrategy.DISABLED,
    errorStrategy = @ErrorStrategy(value = RETRY_ON_ERROR, retryDelay = "50ms", retryCount=3),
    groupId="order-placed-group",
    threads=10)
public class OrderPlacedConsumer {

  @Topic("order-placed")
  @SendTo("order-metrics")
  Integer receiveOrder(@KafkaKey String customer,
                    OrderEvent orderEvent,
                    Acknowledgement acknowledgement) {
    System.out.println(
        "Received order from customer: " + customer
    );

    acknowledgement.ack();

    return orderEvent.getProducts().size();
  }
}
