package com.github.SakuraMatrix.webflux.config;

//import java.beans.BeanProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfig {
  @Bean
  public WebClient webClient() {
    return WebClient.create();
  }
}


