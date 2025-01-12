package com.example.demo.basicDemo;

public class Cat implements Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hi im a Cat, my name is " + name  + ", nice to meet you!");
    }
}
