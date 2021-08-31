// need to put UUID into rest of file

package com.github.SakuraMatrix.P2ProjectBalashov.htmlServer.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Table("customers")
public class Customer {
  @PrimaryKey
  private UUID id = UUID.randomUUID();
  private String fname;
  private String lname;
  private double walletBalance = 0.00;

  // no-args constructor
  public Customer() {
    }

  // args constructor
public Customer(int id, String fname, String lname){
    this.id = id;
    this.fname = fname;
    this.lname = lname;
}

  @Override
  public String toString() {
    return "Customer{" + "id= " + id + ", fname='" + fname + '\'' + ", lname=' " + lname + '\'' +'}';
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Customer customer = (Customer) obj;
    return id == customer.id && Objects.equals(fname, customer.fname) && Objects.equals(lname, customer.lname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fname, lname);
  }

  /** lines 41-64 are the setters and getters for the object's components */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

}
