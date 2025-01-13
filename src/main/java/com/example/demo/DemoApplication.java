package com.example.demo;

import com.example.demo.basicDemo.Animal;
import com.example.demo.basicDemo.Dog;
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

	@Autowired
	Dog dog;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void onLoadDemo() {
		animal.setName("Bulma");
		animal.sayHello();


		dog.sayHello();

	}


}
