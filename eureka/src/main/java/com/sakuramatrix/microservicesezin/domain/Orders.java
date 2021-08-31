package com.sakuramatrix.microservicesezin.domain;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.Random;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @PrimaryKeyColumn(name = "customer_id", type = PrimaryKeyType.PARTITIONED)
    @PrimaryKey("customer_id")
    private int id = new Random().nextInt(99999);
    @Column
    private int item_id;
    @Column
    private double price;
}









