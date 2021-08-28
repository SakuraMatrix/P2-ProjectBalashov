package com.github.SakuraMatrix.P2ProjectBalashov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Scifi {

	public static void main(String[] args) {
		SpringApplication.run(Scifi.class, args);
	}

	@GetMapping("/")
	public Mono<String> eureka() {
		return Mono.just("Experimenting with Eureka for Project 2!");
	}

}
