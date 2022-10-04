package com.example;

import io.micronaut.core.annotation.Introspected;

import java.util.Date;
import java.util.List;

@Introspected
public class OrderEvent {
  private final String id;
  private final String customer;
  private final Date dateCreated;
  private final List<String> products;

  public OrderEvent(String id, String customer, Date dateCreated, List<String> products) {
    this.id = id;
    this.customer = customer;
    this.dateCreated = dateCreated;
    this.products = products;
  }

  public String getId() {
    return id;
  }

  public String getCustomer() {
    return customer;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public List<String> getProducts() {
    return products;
  }
}
