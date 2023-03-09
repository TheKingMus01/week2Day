package com.spring.aop;

public class MyService {

    @TimeIt
    public void myMethod() {
       System.out.println("hellooooo");
    }
}
