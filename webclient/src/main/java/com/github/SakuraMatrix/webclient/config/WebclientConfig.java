package com.github.SakuraMatrix.webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebclientConfig {
  @Bean
  public WebClient webClient() {
    return WebClient.create();
  }
}
