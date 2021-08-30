package com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.beans.Transient;
import java.io.Serializable;
import java.util.*;

@Table("orders")
public class CartItem implements Serializable {

  @PrimaryKeyColumn(name = "cartItem_id", type = PrimaryKeyType.PARTITIONED)
  @PrimaryKey("cartItem_id")
  private int id = new Random().nextInt(99999);
  @Column
  private String name = "New CartItem";
  @Column
  private double price = -1;
  @Column
  private int quantity = -1;
  @Column
  private Set<String> category = new HashSet<>();

  public CartItem() {
  }

  public CartItem(int cartItem_id, String name, double price, int quantity, Set<String> category) {
    this.id = cartItem_id;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.category = category;
  }

  public CartItem(int cartItem_id, String name, double price, int quantity, String... category) {
    this(cartItem_id, name, price, quantity, new HashSet<>(Arrays.asList(category)));
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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Set<String> getCategory() {
    return category;
  }

  public void setCategory(Set<String> category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Item item = (Item) o;
    return id == item.id && Double.compare(item.price, price) == 0 && Objects.equals(name, item.name)
      && Integer.compare(quantity, item.quantity) && Objects.equals(category, item.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, quantity, category);
  }

  @Override
  public String toString() {
    return "Item{" + "id=" + id + ", name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + ", category=" + category + '}';
  }

  @Transient
  public float getSubtotal() {
    return this.item.getPrice() * quantity;
  }
}
