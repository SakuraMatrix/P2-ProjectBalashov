package com.github.SakuraMatrix.webclient.controller;

import com.github.SakuraMatrix.webclient.domain.Item;
import com.github.SakuraMatrix.webclient.service.WebclientService;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping(value = "/items")
public class WebclientController {
  @Autowired
  private WebclientService webclientService;

  public WebclientController(WebclientService webclientService) {
    this.webclientService = webclientService;
  }

  @GetMapping("")
  public Flux<Item> getAll() {
    return webclientService.getAll();
  }

  @GetMapping("/{itemId}")
  public Mono<Item> getById(@PathVariable int itemId) {
    return webclientService.getById(itemId);
  }

  @GetMapping("/{category}")
  public Flux<Item> getByCategory(@PathVariable String category) {
    return webclientService.getByCategory(category);
  }

  @GetMapping("/{price}")
  public Flux<Item> getByPrice(@PathVariable double price) {
    return webclientService.getByPrice(price);
  }

  @PostMapping("")
  public Mono<Item> createItem(@RequestBody Item item) {
    return webclientService.createItem(item);
  }

  @PutMapping("/{itemId}")
  public Mono<Item> updateItem(@PathVariable int itemId) {
    return webclientService.updateItem(itemId);
  }

  @DeleteMapping("/{itemId}")
  public void deleteItem(@PathVariable int itemId) {
    webclientService.deleteItem(itemId);
  }
}
