package org.example;




public class Insurance {
    public static void main(String[] args) {

        RegAndAuth regAndAuth = new RegAndAuth();

        Users customers = new Customers("001", "Rahul", "rahul.singh@gmail.com", "123456", "Garkha");
        //above is just creation of an object so we need to make it registered
        regAndAuth.registration(customers); //this will create a entry into map

        Users admin = new Admin("100","Pradeep", "pradeep.ranjan@gmail.com","12345");
        regAndAuth.registration(admin);

        regAndAuth.checkAuth("rahul.singh@gmail.com", "123456");
        regAndAuth.checkAuth("rahul.singh@gmail.com", "1234569");
        regAndAuth.checkAuth("pradeep.ranjan@gmail.com", "12345");

    }
}
