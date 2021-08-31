package com.github.SakuraMatrix.webflux.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;

@Table("items")
public class Item {
  @PrimaryKeyColumn(name="id", type=PrimaryKeyType.PARTITIONED)
  private int id;
  private String name;
  private double price;
  private String category;

  public Item() {
  }

  public Item(int id, String name, double price, String category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Item{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", category='" + category + '\'' + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Item item = (Item) obj;
    return id == item.id && Objects.equals(name, item.name) && Double.compare(item.price, price) == 0 && Objects.equals(category, item.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, category);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }
  
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
