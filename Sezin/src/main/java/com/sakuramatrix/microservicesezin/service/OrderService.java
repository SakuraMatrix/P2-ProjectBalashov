package com.sakuramatrix.microservicesezin.service;

import com.sakuramatrix.microservicesezin.domain.Order;
import com.sakuramatrix.microservicesezin.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

    @Service
    public class OrderService {

        Logger log= LoggerFactory.getLogger(OrderService.class);
        private OrderRepository orderRepository;

        public OrderService(OrderRepository orderRepository) {
            this.orderRepository = orderRepository;
        }

        public Flux<Order> getAll() { log.info("All orders:");
            return orderRepository.getAll();

        }

        public Mono<Order> get(int customerId) { log.info("Orders by customerId:");
            return orderRepository.get(customerId);
        }

        public Order create(Order order) {log.info("Creating new orders:");
            return orderRepository.create(order);
        }

    }

