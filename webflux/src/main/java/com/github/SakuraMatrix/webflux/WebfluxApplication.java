package com.github.SakuraMatrix.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.http.server.HttpServer;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.context.annotation.Bean;
import com.github.SakuraMatrix.webflux.config.AppConfig;

import java.beans.BeanProperty;
import java.time.Duration;

@SpringBootApplication
public class WebfluxApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
		AnnotationConfigApplicationContext appCon = new AnnotationConfigApplicationContext(AppConfig.class);
        appCon.getBean(HttpServer.class).bindUntilJavaShutdown(Duration.ofSeconds(60), null);
	}

}
