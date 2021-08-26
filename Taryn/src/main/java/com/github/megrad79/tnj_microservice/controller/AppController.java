package com.github.megrad79.tnj_microservice.controller;

import com.github.megrad79.tnj_microservice.domain.App;
import com.github.megrad79.tnj_microservice.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("app")
public class AppController {

    @Autowired
    AppService appService;

    @PostConstruct
    public void saveApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App(123, "John Doe", "Delaware", "jdoe@xyz.com", 31));
        apps.add(new App(324, "Adam Smith", "North Carolina", "asmith@xyz.com", 43));
        apps.add(new App(355, "Kevin Dunner", "Virginia", "kdunner@xyz.com", 24));
        apps.add(new App(643, "Mike Lauren", "New York", "mlauren@xyz.com", 41));
        appService.initializeApps(apps);
    }

    @GetMapping("/list")
    public Flux<App> getAllApps() {
        Flux<App> apps = appService.getAllApps();
        return apps;
    }

    @GetMapping("/{id}")
    public Mono<App> getAppById(@PathVariable int id) {
        return appService.getAppById(id);
    }

    @GetMapping("/filterByAge/{age}")
    public Flux<App> getAppsFilterByAge(@PathVariable int age) {
        return appService.getAppsFilterByAge(age);
    }
}
