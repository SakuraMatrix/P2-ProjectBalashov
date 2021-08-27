package com.github.Balashov.Lane.controller;

import com.github.Balashov.Lane.domain.Item;
import com.github.Balashov.Lane.service.ItemService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("")
    public Flux<Item> findAll() {
        return itemService.findAll().log();
    }

    @GetMapping("/byId/{id}")
    public Mono<Item> findById(@PathVariable int id) {
        return itemService.findById(id).log();
    }

    @GetMapping("/byCategory/{category}")
    public Flux<Item> findByCategory(@PathVariable String category) {
        return itemService.findByCategory(category).log();
    }

    @GetMapping("/byName/{name}")
    public Flux<Item> findByName(@PathVariable String name) {
        return itemService.findByName(name).log();
    }

    @PostMapping("")
    public Mono<Item>save(@RequestBody Item item) {
        return itemService.save(item).log();
    }

    @PutMapping("/update/{id}")
    public Mono<Item> update(@PathVariable int id, @RequestBody Item item) {
        return itemService.update(id, item).log();
    }





}
