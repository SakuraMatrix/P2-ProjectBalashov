package com.github.SakuraMatrix.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.http.server.HttpServer;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Bean;

//import java.beans.BeanProperty;
import java.time.Duration;

@SpringBootApplication
public class WebFluxApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(WebFluxApplication.class, args);
	}

}
