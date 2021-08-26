package com.sakuramatrix.microservicesezin.repository;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.sakuramatrix.microservicesezin.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

    @Repository
    public class OrderRepository {

        Logger log= LoggerFactory.getLogger(OrderRepository.class);

        private CqlSession session;
        public OrderRepository(CqlSession session) {
            this.session = session;
        }

        public Flux<Order> getAll() {log.info("Getting all orders");
            return Flux.from(session.executeReactive("SELECT * FROM scifi.orders"))
                    .map(row -> new Order(row.getInt("customerId"),row.getInt("itemId"), row.getString("itemName"), row.getDouble("itemPrice"), row.getString("itemCategory")));
        }

        public Mono<Order> get(int customerId) {log.info("Selecting order by customerId ");
            return Mono.from(session.executeReactive("SELECT * FROM scifi.orders WHERE customerId = " + customerId))
                    .map(row -> new Order(row.getInt("customerId"),row.getInt("itemId"), row.getString("itemName"), row.getDouble("itemPrice"), row.getString("itemCategory") ));
        }

        public Order create(Order order) {log.info("Creating an order");
            SimpleStatement stmt = SimpleStatement.builder("INSERT INTO scifi.orders (customerId,itemId,itemName,itemPrice,itemCategory,numberOfOrders) values (?,?,?,?,?)")
                    .addPositionalValues(order.getCustomerId(), order.getItemId(),order.getItemName(),order.getItemPrice(),order.getItemCategory())
                    .build();
            Flux.from(session.executeReactive(stmt)).subscribe();
            return order;
        }
    }

