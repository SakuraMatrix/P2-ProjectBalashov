package com.github.SakuraMatrix.webclient.service;

import com.github.SakuraMatrix.webclient.domain.Item;
import com.github.SakuraMatrix.webclient.domain.Orders;
import com.github.SakuraMatrix.webclient.domain.Customer;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebclientService {
  private WebClient webClient;

  public WebclientService(WebClient webClient) {
    this.webClient = webClient;
  }

  // Item Service
  public Mono<Long> count() {
    return webClient.get().uri("localhost:8080/items/count").retrieve().bodyToMono(Long.class);
  }

  public Flux<Item> findAllItems() {
    return webClient.get().uri("localhost:8080/items").retrieve().bodyToFlux(Item.class);
  }

  public Mono<Item> findByItemId(int item_id) {
    return webClient.get().uri("localhost:8080/items/byId/{item_id}", item_id).retrieve().bodyToMono(Item.class);
  }

  public Flux<Item> findByCategory(String category) {
    return webClient.get().uri("localhost:8080/items/byCategory/{category}", category).retrieve().bodyToFlux(Item.class);
  }

  public Flux<Item> findByName(String name) {
    return webClient.get().uri("localhost:8080/items/byName/{name}", name).retrieve().bodyToFlux(Item.class);
  }

  public Mono<Item> save(Item item) {
    return webClient.post().uri("localhost:8080/items").body(Mono.just(item), Item.class).retrieve().bodyToMono(Item.class);
  }

  public Mono<Item> updateItem(int item_id) {
    return webClient.put().uri("localhost:8080/items/update/{item_id}", item_id).body(Mono.just(item_id), Item.class).retrieve().bodyToMono(Item.class);
  }

  public Mono<Item> addCategoryById(int item_id, String category) {
    return webClient.put().uri("localhost:8080/items/addCategory/{id}").body(Mono.just(category), Item.class).retrieve().bodyToMono(Item.class);
  }

  public Mono<Item> addCategoryToItem(int item_id, String category) {
    return webClient.put().uri("localhost:8080/items/addCategory/{id}/{categories}").body(Mono.just(category), Item.class).retrieve().bodyToMono(Item.class);
  }

  //Order Service

  public Mono<Void> deleteById(int customer_id) {
    return webClient.delete().uri("localhost:8081/orders/{customer_id}", customer_id).retrieve().bodyToMono(Void.class);
  }

  public Flux<Orders> findAllOrders() {
    return webClient.get().uri("localhost:8081/orders/all").retrieve().bodyToFlux(Orders.class);
  }

  public Mono<Orders> saveById(int customer_id, Orders orders) {
    return webClient.post().uri("localhost:8081/orders/{customer_id}", customer_id).retrieve().bodyToMono(Orders.class);
  }

  public Flux<Orders> findByOrderId(int customer_id) {
    return webClient.get().uri("localhost:8081/orders/{customer_id}", customer_id).retrieve().bodyToFlux(Orders.class);
  }

  public Flux<Orders> updateById(int customer_id, Orders orders) {
    return webClient.put().uri("localhost:8081/orders/update/{customer_id}", customer_id).retrieve().bodyToFlux(Orders.class);
  }

  //Customer Service

  public Mono<Customer> createCustomer(Customer customer) {
    return webClient.post().uri("localhost:8086/customers").body(Mono.just(customer), Customer.class).retrieve().bodyToMono(Customer.class);
  }

  public Mono<Boolean> deposit(int customer, double amt) {
    return webClient.put().uri("localhost:8086/customers/deposit/{customer}", customer).body(Mono.just(amt), Customer.class).retrieve().bodyToMono(Boolean.class);
  }

  public Mono<Boolean> withdraw(int customer, double amt) {
    return webClient.put().uri("localhost:8086/customers/withdraw/{customer}", customer).body(Mono.just(amt), Customer.class).retrieve().bodyToMono(Boolean.class);
  }

  public Flux<Customer> findAllCustomers() {
    return webClient.get().uri("localhost:8086/customers").retrieve().bodyToFlux(Customer.class);
  }

  public Mono<Customer> getCustomerById(int id) {
    return webClient.get().uri("localhost:8086/customers/{id}", id).retrieve().bodyToMono(Customer.class);
  }
}