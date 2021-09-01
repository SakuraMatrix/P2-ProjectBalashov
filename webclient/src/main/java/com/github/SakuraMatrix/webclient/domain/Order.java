package com.github.SakuraMatrix.webclient.domain;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.Random;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders  {
    @PrimaryKeyColumn(name = "customer_id", type = PrimaryKeyType.PARTITIONED)
    @PrimaryKey("customer_id")
    private @Getter @Setter int id = new Random().nextInt(99999);

    @Column
    private @Getter @Setter int item_id;
    @Column
    private @Getter @Setter double price;

}
