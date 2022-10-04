package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

@Controller
public class HelloController {

  private final OrderPlacedProducer producer;

  public HelloController(OrderPlacedProducer producer) {
    this.producer = producer;
  }

  @Post()
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  HttpResponse<?> placeOrder(OrderEvent order) {

    producer.sendProduct(order.getCustomer(), order);

    return HttpResponse.ok();
  }
}


