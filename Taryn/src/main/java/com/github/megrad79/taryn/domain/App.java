package com.github.megrad79.taryn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class App {
    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;
}
