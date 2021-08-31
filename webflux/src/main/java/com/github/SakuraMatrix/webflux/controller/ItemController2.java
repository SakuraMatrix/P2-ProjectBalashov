package com.github.SakuraMatrix.webflux.controller;

import com.github.SakuraMatrix.webflux.domain.Item;
import com.github.SakuraMatrix.webflux.service.HardCodedService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/items")
public class ItemController2 {
  private HardCodedService hcService;

  public ItemController2(HardCodedService hcService) {
    this.hcService = hcService;
  }

  @GetMapping()
  public Flux<Item> getAll() {
    return hcService.findAll();
  }

  @GetMapping("/{itemId}")
  public Mono<Item> getById(@PathVariable int itemId) {
    return hcService.findById(itemId);
  }

  @GetMapping("/{category}")
  public Flux<Item> getByCategory(@PathVariable String category) {
    return hcService.findByCategory(category);
  }

  @GetMapping("/{price}")
  public Flux<Item> getByPrice(@PathVariable double price) {
    return hcService.findByPrice(price);
  }

  @PostMapping()
  public Mono<Item> createItem(@RequestBody Item item) {
    return hcService.createItem(item);
  }

  @PutMapping("/{itemId}")
  public Mono<Item> updateItem(@PathVariable int itemId) {
    return hcService.updateItem(itemId);
  }

  @DeleteMapping("/{itemId}")
  public Mono<Item> deleteItem(@PathVariable int itemId) {
    return hcService.deleteItem(itemId);
  }
}
