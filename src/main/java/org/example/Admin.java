package org.example;

public class Admin extends Users{

    public Admin(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    @Override
    void toDisplay() {
        System.out.println("Name"+ this.getName()+ "Email"+ this.getEmail());
    }
}
