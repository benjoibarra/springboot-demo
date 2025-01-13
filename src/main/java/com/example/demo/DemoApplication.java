package com.example.demo;

import com.example.demo.basicDemo.Animal;
import com.example.demo.basicDemo.Cat;
import com.example.demo.basicDemo.Dog;
import jakarta.annotation.PostConstruct;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {
	// application entry point

	Cat cat;
	Dog dog;

	@Autowired
	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Autowired
	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct //
	public void onBeanLoad() {
		cat.sayHello();
		dog.sayHello();
	}


}
