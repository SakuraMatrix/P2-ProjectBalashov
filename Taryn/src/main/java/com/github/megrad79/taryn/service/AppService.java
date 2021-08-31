package com.github.megrad79.taryn.service;

import com.github.megrad79.taryn.domain.App;
import com.github.megrad79.taryn.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AppService {

    @Autowired
    AppRepository appRepository;

    public void initializeApps(List<App> apps) {
        Flux<App> savedApps = appRepository.saveAll(apps);
        savedApps.subscribe();
    }

    public Flux<App> getAllApps() {
        Flux<App> apps =  appRepository.findAll();
        return apps;
    }

    public Flux<App> getAppsFilterByAge(int age) {
        return appRepository.findByAgeGreaterThan(age);
    }

    public Mono<App> getAppById(int id) {
        return appRepository.findById(id);
    }
}
