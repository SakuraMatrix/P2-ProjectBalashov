package com.github.ProjectBalashov;
import ch.qos.logback.classic.Logger;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import reactor.core.publisher.Flux;

public class CustomerRepository {
    CqlSession session;
    Logger log;
    public CustomerRepository(CqlSession session, Logger log){
        this.session = session;
        this.log = log;
    }
    public Customer createUser(Customer customer){
        log.info("Creating a user: "+customer);
        SimpleStatement simp = SimpleStatement.builder("INSERT INTO paintingSeller.user"+
        "(user_id, username, password, balance) " +
        "values (?, ?, ?, ?)")
        .addPositionalValues()
        .build();
        Flux.from(session.executeReactive(simp)).subscribe();
        System.out.println(customer);
        return customer;
    }
}