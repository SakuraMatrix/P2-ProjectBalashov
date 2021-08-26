package com.sakuramatrix.microservicesezin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import reactor.netty.http.server.HttpServer;

import java.net.URISyntaxException;

@SpringBootApplication
public class ScifiApplication {

    public static void main(String[] args) throws URISyntaxException {
        SpringApplication.run(ScifiApplication.class, args);

        Logger log= LoggerFactory.getLogger(ScifiApplication.class);
        log.info("Sci-Fi app starts");
        Netty();
    }

    private static void Netty() throws URISyntaxException {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {

            applicationContext.getBean(HttpServer.class).bindNow();
        }
    }
}

