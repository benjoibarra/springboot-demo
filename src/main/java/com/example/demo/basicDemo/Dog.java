package com.example.demo.basicDemo;

import org.springframework.stereotype.Component;


@Component("dog")
public class Dog implements Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hi im a dog, my name is " + name  + ", nice to meet you!");
    }
}
