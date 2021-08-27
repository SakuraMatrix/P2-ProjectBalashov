package com.github.Balashov.Lane.controller;

import com.github.Balashov.Lane.domain.Item;
import com.github.Balashov.Lane.service.ItemService;
import com.github.Balashov.Lane.util.IntegerUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Set;

@Component
@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //GET /items
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ServerResponse.ok().body(itemService.findAll(), Item.class)
                .switchIfEmpty(ServerResponse.noContent().build());
    }

    //GET /items/byId/{id}
    public Mono<ServerResponse> findById(ServerRequest request) {
        int id = IntegerUtil.parseInt(request.pathVariable("id"), -1);
        return itemService.findById(id)
                .flatMap(item -> ServerResponse.ok().body(Mono.just(item), Item.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    //GET /items/byName/{name}
    public Mono<ServerResponse> findByName(ServerRequest request) {
        String name = request.pathVariable("name");
        return ServerResponse.ok().body(itemService.findByName(name), Item.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    //GET /items/byCategory/{category}
    public Mono<ServerResponse> findByCategory(ServerRequest request) {
        String category = request.pathVariable("category");
        return ServerResponse.ok().body(itemService.findByCategory(category), Item.class)
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    //POST /items/create
    public Mono<ServerResponse> save(ServerRequest request) {
        return request.bodyToMono(Item.class)
                .flatMap(item -> itemService.save(item))
                .flatMap(item -> ServerResponse.created(URI.create("/items/" + item.getId())).build())
                .switchIfEmpty(ServerResponse.badRequest().build());
    }

    //PUT /items/update/{id}
    public Mono<ServerResponse> update(ServerRequest request) {
        int id = IntegerUtil.parseInt(request.pathVariable("id"), -1);
        return request.bodyToMono(Item.class)
                .flatMap(item -> itemService.update(id, item))
                .flatMap(item -> ServerResponse.created(URI.create("/items/" + item.getId())).build())
                .switchIfEmpty(ServerResponse.badRequest().build());
    }

    @GetMapping("")
    public Flux<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/byId/{id}")
    public Mono<Item> findById(@PathVariable int id) {
        return itemService.findById(id);
    }

    @GetMapping("/byCategory/{category}")
    public Flux<Item> findByCategory(@PathVariable String category) {
        return itemService.findByCategory(category);
    }

    @GetMapping("/byName/{name}")
    public Flux<Item> findByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @PostMapping("")
    public Mono<Item> save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/update/{id}")
    public Mono<Item> update(@PathVariable int id, @RequestBody Item item) {
        return itemService.update(id, item);
    }
}
