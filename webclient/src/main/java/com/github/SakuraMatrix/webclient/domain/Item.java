package com.github.SakuraMatrix.webclient.domain;

import java.util.Objects;

public class Item {
  private int itemId;
  private String itemName;
  private double price;
  private String category;

  public Item() {
  }

  public Item(int itemId, String itemName, double price, String category) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.price = price;
    this.category = category;
  }

  @Override
  public String toString() {
    return "Item{" + "itemId=" + itemId + ", itemName='" + itemName + '\'' + ", price=" + price + ", category='" + category + '\''
        + '}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Item item = (Item) obj;
    return itemId == item.itemId && Objects.equals(itemName, item.itemName) && Double.compare(item.price, price) == 0
        && Objects.equals(category, item.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, itemName, price, category);
  }

  public int getId() {
    return itemId;
  }

  public void setId(int itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
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