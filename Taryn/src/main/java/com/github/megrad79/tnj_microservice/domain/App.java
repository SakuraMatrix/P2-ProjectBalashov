package com.github.megrad79.tnj_microservice.domain;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
>>>>>>> 0056066f8ce709e5e5c359907cc52109e75ea438
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
=======
>>>>>>> 0056066f8ce709e5e5c359907cc52109e75ea438
public class App {
    @PrimaryKey
    private int id;
    private String name;
    private String address;
    private String email;
    private int age;
<<<<<<< HEAD
=======

    public App(int id, String name, String address, String email, int age) {
    }
>>>>>>> 0056066f8ce709e5e5c359907cc52109e75ea438
}
