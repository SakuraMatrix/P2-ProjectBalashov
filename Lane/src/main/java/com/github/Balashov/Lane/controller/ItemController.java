package com.github.Balashov.Lane.controller;

import com.github.Balashov.Lane.model.Item;
import com.github.Balashov.Lane.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("")
    public Flux<Item> all() {
        return itemRepository.findAll();
    }

    @GetMapping("/filter/byId/{id}")
    public Mono<Item> byId(@PathVariable int id) {
        return itemRepository.findById(id);
    }

    @GetMapping("/filter/byCategory/{category}")
    public Flux<Item> byCategory(@PathVariable String category) {
        return itemRepository.findByCategory(category);
    }

    @PostMapping("/create")
    public Mono<Item> create(@RequestBody Item item) {
        return itemRepository.save(item);
    }

}
