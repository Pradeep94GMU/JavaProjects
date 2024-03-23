package org.example;

public class Customers extends Users {

  protected String address;

  public Customers(String id, String name, String email, String password, String address) {
    super(id, name, email, password);
    this.address = address;
  }

  public Customers() {

  }

  @Override
  void toDisplay() {
    System.out.println("Name"+ this.getName() + "Email"+ this.getEmail() + "Address"+ this.address);
  }

}
