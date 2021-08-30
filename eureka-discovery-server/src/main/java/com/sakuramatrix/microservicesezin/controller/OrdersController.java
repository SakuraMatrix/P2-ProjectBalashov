package com.sakuramatrix.microservicesezin.controller;

import com.sakuramatrix.microservicesezin.domain.Orders;
import com.sakuramatrix.microservicesezin.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/orders")
public class OrdersController {

        @Autowired
        private OrdersRepository ordersRepository;


        @GetMapping("/{customer_id}")
        public Flux<Orders> getById(@PathVariable int customer_id){
                return ordersRepository.findById(customer_id);
        }

        @GetMapping("/all")
        public Flux<Orders> getAllOrders(){
                return ordersRepository.findAll();
        }

        }

