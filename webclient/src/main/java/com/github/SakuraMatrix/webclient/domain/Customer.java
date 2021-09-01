package com.github.SakuraMatrix.webclient.domain;

public class Customer {
  int customer_id;
  double balance;

  public Customer(int customer_id, double balance) {
    this.customer_id = customer_id;
    this.balance = balance;
  }

  public int getId() {
    return customer_id;
  }

  public void setId(int id) {
    this.customer_id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}