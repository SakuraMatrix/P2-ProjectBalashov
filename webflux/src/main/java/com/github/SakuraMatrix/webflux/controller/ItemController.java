package com.github.SakuraMatrix.webflux.controller;

import com.github.SakuraMatrix.webflux.domain.Item;
import com.github.SakuraMatrix.webflux.service.ItemService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
  private final ItemService itemService;

  public ItemController(ItemService itemService) {
    this.itemService = itemService;
  }

  @GetMapping("")
  public Flux<Item> getAll() {
    return itemService.getAll();
  }

  @GetMapping("/{id}")
  public Mono<Item> get(@PathVariable("id") int id) {
    return itemService.get(id);
  }

  @GetMapping("/{category}")
  public Flux<Item> get(@PathVariable("category") String category) {
    return itemService.get(category);
  }

  @GetMapping("/{price}")
  public Flux<Item> get(@PathVariable("price") double price) {
    return itemService.get(price);
  }

  @PostMapping("")
  public Mono<Item> create(@RequestBody Item item) {
    return itemService.create(item);
  }
}