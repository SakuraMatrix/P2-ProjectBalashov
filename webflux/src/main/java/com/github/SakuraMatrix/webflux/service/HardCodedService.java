package com.github.SakuraMatrix.webflux.service;

import com.github.SakuraMatrix.webflux.domain.Item;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HardCodedService {
  private WebClient webClient;

  public HardCodedService(WebClient webClient) {
    this.webClient = webClient;
  }

  public Flux<Item> getAll() {
    return webClient.get()
      .uri("localhost:3000/items")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Mono<Item> getById(int itemId) {
    return webClient.get()
      .uri("localhost:3000/items/{itemId}")
      .retrieve()
      .bodyToMono(Item.class);
  }

  public Flux<Item> getByCategory(String category) {
    return webClient.get()
      .uri("localhost:3000/items/{category}")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Flux<Item> getByPrice(double price) {
    return webClient.get()
      .uri("localhost:3000/items/{price}")
      .retrieve()
      .bodyToFlux(Item.class);
  }

  public Mono<Item> createItem(Item item) {
    return webClient.post()
        .uri("localhost:3000/items")
        .body(Mono.just(item), Item.class)
        .retrieve()
        .bodyToMono(Item.class);
  }

  public Mono<Item> updateItem(int itemId) {
    return webClient.put()
    .uri("localhost:3000/items/{itemId}")
    .body(Mono.just(itemId), Item.class)
    .retrieve()
    .bodyToMono(Item.class);
  }

  public void deleteItem(int itemId) {
    webClient.delete()
      .uri("localhost:3000/items/{itemId}", itemId)
      .retrieve()
      .bodyToMono(Void.class)
      .subscribe();
  }
}