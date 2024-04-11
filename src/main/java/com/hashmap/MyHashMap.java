package com.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class MyHashMap {
    public static void main(String[] args) {

        Employee emp1 = new Employee(1);
        Employee emp2 = new Employee(1);

        HashMap<Employee, String> map = new HashMap<>(0);
        map.put(emp1, "Rahul");
        map.put(emp2, "Rahul");



        System.out.println(map.size()); //2





    }
}

class Employee{
    int id;
    public Employee(int id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
