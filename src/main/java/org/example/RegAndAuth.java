package org.example;

import java.util.HashMap;

public class RegAndAuth {

  //i need to make a map to store all the users
  HashMap<String, Users> map = new HashMap<>();

  public void registration(Users users){
    if(!map.containsKey(users.getEmail())){
      map.put(users.getEmail(), users);
      System.out.println("Registration Successful of new User");
      return;
    }
    else{
      System.out.println("User already exist");
      return;
    }

  }

  //now we need to check the authentication
  public void checkAuth(String email, String pass){

    Users users = map.get(email);

    System.out.println("Detail: "+ users.getEmail());

    if(users != null && users.getPassword().equals(pass)){
      System.out.println("This User is authentic..");
      return;
    }
    else {
      System.out.println("THis is not a valid user");
    }

  }


}
