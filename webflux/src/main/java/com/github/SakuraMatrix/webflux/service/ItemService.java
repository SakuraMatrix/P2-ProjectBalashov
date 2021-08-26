package com.SakuraMatrix.webflux.service;

import com.github.SakuraMatrix.webflux.domain.Item;
import com.github.SakuraMatrix.webflux.repository.ItemRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemService {
  private final ItemRepository itemRepo;

  public ItemService(ItemRepository itemRepo) {
    this.itemRepo = itemRepo;
  }

  public Flux<Item> getAll() {
    return itemRepo.findAll();
  }

  public Mono<Item> get(int id) {
    return itemRepo.findById(id);
  }

  public Flux<Item> getByCategory(String category) {
    return itemRepo.findByCategory(category);
  }

  public Flux<Item> getByPrice(double price) {
    return itemRepo.findByPrice(price);
  }

  public Mono<Item> create(Item item) {
    return itemRepo.create(item);
  }
}
