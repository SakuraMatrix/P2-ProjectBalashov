package com.github.megrad79.tnj_microservice.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class App {
    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;

    public App(int id, String name, String address, String email, int age) {
    }
}
