package com.github.SakuraMatrix.webclient.service;

import com.github.SakuraMatrix.webclient.domain.Item;
import com.github.SakuraMatrix.webclient.domain.Orders;
import com.github.SakuraMatrix.webclient.domain.Customer;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import com.datastax.oss.driver.api.querybuilder.update.Update;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class WebclientService {
  private WebClient webClient;

  public WebclientService(WebClient webClient) {
    this.webClient = webClient;
  }

  //Item Service
  public Mono<Long> count() {
    return webClient.count();
  }

  public Flux<Item> findAllItems() {
    return webClient.findAllItems();
  }

  public Mono<Item> findByItemId(int id) {
    return webClient.findByItemId(id);
  }

  public Flux<Item> findByCategory(String category) {
    return webClient.findByCategory(category);
  }

  public Flux<Item> findByName(String name) {
    return webClient.findByName(name);
  }

  public Mono<Item> save(Item item) {
    return findById(item.getId()).log().switchIfEmpty(webClient.save(item)).log();
  }

  public Mono<Item> update(int id, Item item) {
    return findByItemId(id).flatMap(foundItem -> {
      String name = item.getName();
      double price = item.getPrice();
      Set<String> category = item.getCategory();

      if (name != null && !name.isEmpty() && !"new item".equalsIgnoreCase(name)) {
        foundItem.setName(name);
      }
      if (price != -1) {
        foundItem.setPrice(price);
      }
      if (category.stream().count() > 0) {
        foundItem.setCategory(category);
      }

      return webClient.save(foundItem);
    });
  }

  public Mono<Item> addCategoryToItem(int id, String[] category) {
    return findByItemId(id).flatMap(item -> {
      Set<String> itemCategory = item.getCategory(); // retrieve the categories
      itemCategory.addAll(Arrays.asList(category)); // add the new categories
      item.setCategory(itemCategory); // reapply the categories
      return update(id, item); // update it
    });

  }

  public Flux<Item> generate() {
    return webClient
        .saveAll(Arrays.asList(new Item(0001, "Millennium Falcon", 3000, "Star Wars", "Figurine", "Spaceship"),
            new Item(0002, "Death Star", 5000, "Star Wars", "Figurine", "Spaceship"),
            new Item(0003, "Light Saber", 50, "Star Wars", "Figurine", "Weapon"),
            new Item(0004, "Normandy", 3000, "Mass Effect", "Figurine", "Spaceship")));
  }

  //Order Service
  public void deleteById(int customer_id) {
    webClient.deleteById(customer_id).subscribe();
  }

  public Mono<Orders> saveById(@RequestBody Orders orders) {
    return webClient.save(orders);
  }

  public Flux<Orders> findByOrderId(@PathVariable int customer_id) {
    return webClient.findByOrderId(customer_id);
  }

  public Flux<Orders> updateById(int customer_id, Orders orders) {
    return findById(customer_id).flatMap(foundOrder -> {
      int item_id = orders.getItem_id();
      double price = orders.getPrice();

      if (item_id > 0) {
        foundOrder.setItem_id(item_id);
      }

      if (price > 0) {
        foundOrder.setPrice(price);
      }

      return saveById(foundOrder);
    });
  }

  //Customer Service
  CqlSession session;

  public Customer createCustomer(Customer customer) {
    SimpleStatement simp = SimpleStatement
        .builder("INSERT INTO Scifi.customers" + "(customer_id, balance) " + "values (?, ?)")
        .addPositionalValues(customer.getId(), customer.getBalance()).build();
    Flux.from(session.executeReactive(simp)).subscribe();
    System.out.println(customer);
    return customer;
  }

  public Mono<Boolean> deposit(int customer_id, double amt) {
    boolean flag;
    try {
      // update account value
      getCustomerById(customer_id).subscribe(customer -> {

        double newBalance = customer.getBalance() + amt;
        customer.setBalance(newBalance);

        Update updateAccount = QueryBuilder.update("scifi", "customers")
            .setColumn("balance", literal(customer.getBalance())).whereColumn("customer_id")
            .isEqualTo(literal(customer_id));

        Flux.just(updateAccount.build()).flatMap(session::executeReactive).subscribe();
      });
      flag = true;
    } catch (RuntimeException e) {
      flag = false;
    }
    return Mono.just(flag);
  }

  public Mono<Boolean> withdraw(int customer_id, double amt) {
    boolean flag = true;
    try {
      // update account value
      getCustomerById(customer_id).subscribe(customer -> {

        if (customer.getBalance() > amt) {

          double newBalance = customer.getBalance() - amt;
          customer.setBalance(newBalance);

          Update updateAccount = QueryBuilder.update("scifi", "customers")
              .setColumn("balance", literal(customer.getBalance())).whereColumn("customer_id")
              .isEqualTo(literal(customer_id));

          Flux.just(updateAccount.build()).flatMap(session::executeReactive).subscribe();
        } else {
          
        }

      });

    } catch (RuntimeException e) {
      
      flag = false;
    }
    return Mono.just(flag);
  }

  public Mono<Customer> getCustomerById(int id) {
    Select select = QueryBuilder.selectFrom("scifi", "customers").columns("customer_id", "balance")
        .whereColumn("customer_id").isEqualTo(literal(id));

    return Mono.from(session.executeReactive(select.build()))
        .map(row -> new Customer(row.getInt("customer_id"), row.getDouble("balance")));
  }

  public Flux<Customer> getAllCustomers() {
    Select select = QueryBuilder.selectFrom("scifi", "customers").columns("customer_id", "balance");
    return Flux.from(session.executeReactive(select.build()))
        .map(row -> new Customer(row.getInt("customer_id"), row.getDouble("balance")));
  }
}