package com.github.Balashov.Lane.service;


import com.github.Balashov.Lane.domain.Item;
import com.github.Balashov.Lane.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class ItemService{

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //@GetMapping("")
    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }

    //@GetMapping("/filter/byId/{id}")
    public Mono<Item> findById(@PathVariable int id) {
        return itemRepository.findById(id);
    }

    //@GetMapping("/filter/byCategory/{category}")
    public Flux<Item> findByCategory(@PathVariable String category) {
        return itemRepository.findByCategory(category);
    }

    //@GetMapping("/filter/byName/{name}")
    public Flux<Item> findByName(@PathVariable String name) {
        return itemRepository.findByName(name);
    }

    //@PostMapping("/create")
    public Mono<Item> save(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    //@PutMapping("/update/{id}")
    public Mono<Item> update(int id, Item item) {
        return findById(id).flatMap(foundItem -> {
            String name = item.getName();
            double price = item.getPrice();
            Set<String> category = item.getCategory();

            if (name != null && !name.isEmpty() && !"new item".equalsIgnoreCase(name)) {
                foundItem.setName(name);
            }
            if (price != -1)  {
                foundItem.setPrice(price);
            }
            if (category.stream().count() > 0) {
                foundItem.setCategory(category);
            }

            return save(foundItem);
        });
    }


}
