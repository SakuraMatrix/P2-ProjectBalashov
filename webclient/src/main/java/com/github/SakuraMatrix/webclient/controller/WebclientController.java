package com.github.SakuraMatrix.webclient.controller;

import com.github.SakuraMatrix.webclient.domain.Item;
import com.github.SakuraMatrix.webclient.domain.Orders;
import com.github.SakuraMatrix.webclient.domain.Customer;
import com.github.SakuraMatrix.webclient.service.WebclientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebclientController {

  private WebclientService webclientService;

  public WebclientController(WebclientService webclientService) {
    this.webclientService = webclientService;
  }

  // Item mapping
  // @GetMapping("/items/count")
  // public Mono<Long> count() {
  //   return webclientService.count();
  // }

  @GetMapping("/items")
  public Flux<Item> findAllItems() {
    return webclientService.findAllItems();
  }

  @PostMapping("/items")
  public Mono<Item> save(@RequestBody Item item) {
    return webclientService.save(item);
  }

  @GetMapping("/items/byId/{id}")
  public Mono<Item> findByItemId(@PathVariable int id) {
    return webclientService.findByItemId(id);
  }

  @GetMapping("/items/byCategory/{category}")
  public Flux<Item> findByCategory(@PathVariable String category) {
    return webclientService.findByCategory(category);
  }

  @GetMapping("/items/byName/{name}")
  public Flux<Item> findByName(@PathVariable String name) {
    return webclientService.findByName(name);
  }

  @PutMapping("/items/update/{id}")
  public Mono<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
    // return webclientService.updateItem(id, item);
    return webclientService.updateItem(id);
  }

  @PutMapping("/items/addCategory/{id}")
  public Mono<Item> addCategoryById(@PathVariable int id, @PathVariable String category) {
    return webclientService.addCategoryById(id, category);
  }

  @PutMapping("/items/addCategory/{id}/{categories}")
  public Mono<Item> addCategoryToItem(@PathVariable int id, @PathVariable String category) {
    return webclientService.addCategoryToItem(id, category);
  }


  //Orders mapping
  @GetMapping("/orders/{customer_id}")
  public Flux<Orders> findByOrderId(@PathVariable int customer_id) {
    return webclientService.findByOrderId(customer_id);
  }

  @GetMapping("/orders/all")
  public Flux<Orders> findAllOrders() {
    return webclientService.findAllOrders();
  }

  @PostMapping("/orders/{customer_id}")
  public Mono<Orders> saveById(@PathVariable int customer_id, @RequestBody Orders orders) {
    return webclientService.saveById(customer_id, orders);
  }

  @PutMapping("/orders/update/{customer_id}")
  public Flux<Orders> updateById(@PathVariable int customer_id, @RequestBody Orders orders) {
    return webclientService.updateById(customer_id, orders);
  }

  @DeleteMapping("/orders/{customer_id}")
  public void deleteById(@PathVariable int customer_id) {
    webclientService.deleteById(customer_id);
  }

  //Customers Mapping
  @GetMapping("/customers")
  public Flux<Customer> findAllCustomers() {
    return webclientService.findAllCustomers();
  }

  @GetMapping("/customers/{id}")
  public Mono<Customer> getByCustomerId(@PathVariable int id) {
    return webclientService.getCustomerById(id);
  }

  @PostMapping("/customers")
  public Mono<Customer> createCustomer(@RequestBody Customer customer) {
    return webclientService.createCustomer(customer);
  }

  // @PutMapping("/customers/deposit/{customer}")
  // public Mono<Boolean> deposit(@PathVariable int customer, @RequestBody double amt) {
  //   return webclientService.deposit(customer, amt);
  // }

  // @PutMapping("/customers/withdraw/{customer}")
  // public Mono<Boolean> withdraw(@PathVariable int customer, @RequestBody double amt) {
  //   return webclientService.withdraw(customer, amt);
  // }

}
