package com.github.Balashov.Lane.model;

import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("customers")
public class Customer {

    private UUID id = UUID.randomUUID();

    private String name = "";
    private double walletBalance = 0.00;



}
