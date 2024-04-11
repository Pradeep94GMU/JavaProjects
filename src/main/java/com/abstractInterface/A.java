package com.abstractInterface;

public class A {
    public static void main(String[] args) {
      C c = new C(12);
        System.out.println(c.toString());
    }
}


abstract class B{
  int a;
  public B(int a){
    this.a = a;
  }

}

class C extends B{
  public C(int b){
      super(b);
  }
}
