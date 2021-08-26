package com.github.Balashov.Lane.controller;

import com.github.Balashov.Lane.model.Item;
import com.github.Balashov.Lane.repository.ItemRepository;
import com.github.Balashov.Lane.util.IntegerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
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

    @PostMapping("/create")
    public Mono<Item> create(Item item) {
        return itemRepository.save(item);
    }

}
