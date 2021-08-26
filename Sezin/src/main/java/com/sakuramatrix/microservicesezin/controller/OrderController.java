package com.sakuramatrix.microservicesezin.contoller;

import com.sakuramatrix.microservicesezin.domain.Order;
import com.sakuramatrix.microservicesezin.service.OrderService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

    @RestController
    @RequestMapping(value="/orders")
    public class OrderController {

        private OrderService orderService;

        public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }
        @GetMapping("")
        public Flux<Order> getAll(){return orderService.getAll();
        }

        @GetMapping("/{customerId}")
        public Mono<Order> get(@PathVariable("customerId")int customerId){ return orderService.get(customerId);
        }

        @PostMapping("")
        public Order create(@RequestBody Order order){
            return orderService.create(order);
        }

    }

