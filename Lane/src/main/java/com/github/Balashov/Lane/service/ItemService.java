package com.github.Balashov.Lane.service;


import com.github.Balashov.Lane.domain.Item;
import com.github.Balashov.Lane.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class ItemService{

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Mono<Long> count() {
        return itemRepository.count();
    }

    public Flux<Item> findAll() {
        return itemRepository.findAll();
    }

    public Mono<Item> findById( int id) {
        return itemRepository.findById(id);
    }

    public Flux<Item> findByCategory( String category) {
        return itemRepository.findByCategory(category);
    }

    public Flux<Item> findByName( String name) {
        return itemRepository.findByName(name);
    }

    public Mono<Item> save(Item item) {
        return findById(item.getId()).log()
                .switchIfEmpty(itemRepository.save(item))
                .log();
    }

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

            return itemRepository.save(foundItem);
        });
    }

    public Mono<Void> deleteById(int id) {
        return itemRepository.deleteById(id);
    }

    public Mono<Item> addCategoryToItem(int id, String[] category) {
        return findById(id).flatMap(item -> {
            Set<String> itemCategory = item.getCategory(); //retrieve the categories
            itemCategory.addAll(Arrays.asList(category)); //add the new categories
            item.setCategory(itemCategory); //reapply the categories
            return update(id, item); //update it
        });

    }


    public Flux<Item> generate() {
        return itemRepository.saveAll(Arrays.asList(new Item(0001, "Millennium Falcon", 3000, "Star Wars", "Figurine", "Spaceship"),
                new Item(0002, "Death Star", 5000, "Star Wars", "Figurine", "Spaceship"),
                new Item(0003, "Light Saber", 50, "Star Wars", "Figurine", "Weapon"),
                new Item(0004, "Normandy", 3000, "Mass Effect", "Figurine", "Spaceship")));
    }


}
