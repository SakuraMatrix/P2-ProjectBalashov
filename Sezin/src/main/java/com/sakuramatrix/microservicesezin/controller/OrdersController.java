package com.sakuramatrix.microservicesezin.controller;

import com.sakuramatrix.microservicesezin.domain.Orders;
import com.sakuramatrix.microservicesezin.repository.OrdersRepository;
import com.sakuramatrix.microservicesezin.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @Autowired
    private OrdersRepository ordersRepository;


    @GetMapping("/{customer_id}")
    public Flux<Orders> getById(@PathVariable int customer_id){
        return ordersRepository.findById(customer_id);
    }

    @GetMapping("/all")
    public Flux<Orders> getAllOrders(){
        return  ordersRepository.findAll();
    }

    @PostMapping("/{customer_id}")
    public Mono<Orders> saveById (@RequestBody Orders orders) {
        return ordersService.saveById(orders);
    }

    @PutMapping("/update/{customer_id}")
    public Flux<Orders> updateById (@PathVariable int customer_id, @RequestBody Orders orders) {
        return ordersService.updateById (customer_id, orders);
    }

    @DeleteMapping("/{customer_id}")
    public void delete (@PathVariable int customer_id) {
        ordersService.deleteById (customer_id);
    }
}

