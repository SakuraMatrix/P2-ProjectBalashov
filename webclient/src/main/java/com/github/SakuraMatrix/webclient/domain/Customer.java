package com.github.SakuraMatrix.webclient.domain;

import java.util.Objects;

public class Customer {  
  int customerId;
  double balance;

  public Customer () {

  }

  public Customer(int customerId, double balance) {
    this.customerId = customerId;
    this.balance = balance;
  }

  public int getId() {
    return customerId;
  }

  public void setId(int customerId) {
    this.customerId = customerId;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
    return true;
    if (obj == null || getClass() != obj.getClass())
    return false;
    Customer customer = (Customer) obj;
    return customerId == customer.customerId && Double.compare(customer.balance, balance) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, balance);
  }

  @Override
  public String toString() {
    return "Customer{" + "customerId=" + customerId + ", balance=" + balance + '}';
  }

}