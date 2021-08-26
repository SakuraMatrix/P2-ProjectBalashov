package com.github.Balashov.Lane.repository;

import com.github.Balashov.Lane.model.Item;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ItemRepository extends ReactiveCassandraRepository<Item, Integer> {

    @Query(value = "SELECT * FROM project_two.items WHERE category CONTAINS ?0 ALLOW FILTERING", allowFiltering = true)
    Flux<Item> findByCategory(String category);
}
