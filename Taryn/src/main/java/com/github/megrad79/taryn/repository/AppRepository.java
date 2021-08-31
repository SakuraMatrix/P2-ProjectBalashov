package com.github.megrad79.taryn.repository;

import com.github.megrad79.taryn.domain.App;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;

public interface AppRepository extends ReactiveCassandraRepository<App, Integer> {
    @AllowFiltering
    Flux<App> findByAgeGreaterThan(int age);
}