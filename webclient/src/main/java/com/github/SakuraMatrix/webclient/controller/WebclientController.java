package com.github.SakuraMatrix.webclient.controller;

import com.github.SakuraMatrix.webclient.domain.Item;
import com.github.SakuraMatrix.webclient.domain.Order;
import com.github.SakuraMatrix.webclient.domain.Customer;
import com.github.SakuraMatrix.webclient.service.WebclientService;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
  @GetMapping("/items/count")
  public Mono<Long> count() {
    return webclientService.count();
  }

  /**
   * Retrieve all items
   * 
   * @return
   */
  @GetMapping("/items")
  public Flux<Item> findAllItems() {
    return webclientService.findAllItems();
  }

  /**
   * Save an item to the database (Will overwrite an existing item if not careful
   * 
   * @param item the item to save to database
   * @return returns the item saved as a Mono
   */
  @PostMapping("/items")
  public Mono<Item> save(@RequestBody Item item) {
    return webclientService.save(item).log();
  }

  /**
   * Retrieves an item by the specified id
   * 
   * @param id id of the item requested
   * @return Returns the found item
   */
  @GetMapping("/items/byId/{id}")
  public Mono<Item> findByItemId(@PathVariable int id) {
    return webclientService.findByItemId(id).log();
  }

  /**
   * Retrieves all items with the matching category
   * 
   * @param category Category to search by (doesn't support multiple category
   *                 searches)
   * @return Items with corresponding category
   */
  @GetMapping("/items/byCategory/{category}")
  public Flux<Item> findByCategory(@PathVariable String category) {
    return webclientService.findByCategory(category).log();
  }

  /**
   * Retrieves all items with the matching name
   * 
   * @param name Name to search by
   * @return Items with corresponding name
   */
  @GetMapping("/items/byName/{name}")
  public Flux<Item> findByName(@PathVariable String name) {
    return webclientService.findByName(name).log();
  }

  /**
   * Updates an existing item if it exists
   * 
   * @param id   Item ID to update
   * @param item values from item to use
   * @return Update item
   */
  @PutMapping("/items/update/{id}")
  public Mono<Item> update(@PathVariable int id, @RequestBody Item item) {
    return webclientService.update(id, item).log();
  }

  /**
   * Adds categories to the specified item using item json
   * 
   * @param id
   * @param item
   * @return
   */
  @PutMapping("/items/addCategory/{id}")
  public Mono<Item> addCategoryById(@PathVariable int id, @RequestBody Item item) {
    String[] categories = item.getCategory().toArray(new String[(int) item.getCategory().stream().count()]);
    return webclientService.addCategoryToItem(id, categories);
  }

  /**
   * Adds categories to the specified item using a passed string variable
   * separated by spaces (%20)
   * 
   * @param id         Item id
   * @param categories Single string of categories with spaces (%20) as separator
   * @return Updated item
   */
  @PutMapping("/items/addCategory/{id}/{categories}")
  public Mono<Item> addCategoryById(@PathVariable int id, @PathVariable String categories) {
    String[] array = categories.split(" ");
    return webclientService.addCategoryToItem(id, array);
  }


  //Orders mapping
  @GetMapping("/orders/{customer_id}")
  public Flux<Orders> getByOrderId(@PathVariable int customer_id) {
    log.info("Finding order by customer id");
    return webclientService.findById(customer_id);
  }

  @GetMapping("/orders/all")
  public Flux<Orders> getAllOrders() {
    log.info("Finding all orders ");
    return webclientService.findAll();
  }

  @PostMapping("/orders/{customer_id}")
  public Mono<Orders> saveById(@RequestBody Orders orders) {
    log.info("Saving an order by customer id ");
    return webclientService.saveById(orders);
  }

  @PutMapping("/orders/update/{customer_id}")
  public Flux<Orders> updateById(@PathVariable int customer_id, @RequestBody Orders orders) {
    log.info("Updating an order by customer id ");
    return webclientService.updateById(customer_id, orders);
  }

  @DeleteMapping("/orders/{customer_id}")
  public void delete(@PathVariable int customer_id) {
    log.info("Deleting an order by customer id ");
    webclientService.deleteById(customer_id);
  }

  //Customers Mapping
  @GetMapping("/customers")
  public Flux<Customer> findAllCustomers() {
    return webclientService.getAllCustomers().log();
  }

  @GetMapping("/customers/{id}")
  public Mono<Customer> findByCustomerId(@PathVariable int id) {
    return webclientService.getCustomerById(id).log();
  }

  @PostMapping("/customers")
  public Customer createCustomer(@RequestBody Customer customer) {
    return webclientService.createCustomer(customer);
  }

  @PutMapping("/customers/deposit/{customer}")
  public Mono<Boolean> deposit(@PathVariable int customer, @RequestBody double amt) {
    return webclientService.deposit(customer, amt).log();
  }

  @PutMapping("/customers/withdraw/{customer}")
  public Mono<Boolean> withdraw(@PathVariable int customer, @RequestBody double amt) {
    return webclientService.withdraw(customer, amt).log();
  }

}
