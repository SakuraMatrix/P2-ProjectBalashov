package com.github.SakuraMatrix.webflux.service;

import com.github.SakuraMatrix.webflux.domain.Item;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HardCodedService {
  private WebClient webClient;

  public ItemService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<Item> getAll() {
    return webClient.findAll()
      .uri("localhost:3000/items")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Mono<Item> getById(int itemId) {
    return webClient.findById(itemId)
      .uri("localhost:3000/items/{itemId}")
      .retrieve()
      .bodyToMono(Item.class);
  }

  public Flux<Item> getByCategory(String category) {
    return webClient.findByCategory(category)
      .uri("localhost:3000/items/{category}")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Flux<Item> getByPrice(double price) {
    return webClient.findByPrice(price)
      .uri("localhost:3000/items/{price}")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Mono<Item> createItem(Item item) {
    return webClient.create(item)
        .uri("localhost:3000/items")
        .body(Mono.just(item), Item.class)
        .retrieve()
        .bodyToMono(Item.class);
  }

  public Mono<Item> update(int itemId) {
    return webClient.put(itemId)
    .uri("localhost:3000/items/{itemId}")
    .body(Mono.just(item), Item.class)
    .retrieve()
    .bodyToMono(Item.class);
  }

  public Mono<Item> delete(int itemId) {
    return webClient.delete(itemId)
      .uri("localhost:3000/items/{itemId}")
      .retrieve()
      .bodyToMono(Void.class);
  }
}