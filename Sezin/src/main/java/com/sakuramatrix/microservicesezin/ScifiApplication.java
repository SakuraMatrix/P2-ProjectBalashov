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
        public static void main(String[] args) {
                SpringApplication.run(ScifiApplication.class, args);

        }
}

