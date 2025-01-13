package com.example.demo;

import com.example.demo.basicDemo.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// application entry point

	@Autowired
	@Qualifier("dog")
    Animal animal;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@PostConstruct
	public void onLoadDemo() {
		animal.sayHello();
	}


}
