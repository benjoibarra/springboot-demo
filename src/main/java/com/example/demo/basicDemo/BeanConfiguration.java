package com.example.demo.basicDemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("cat")
    public Cat getCat() {
        Cat catBean = new Cat();
        catBean.setName("Kitty");
        return catBean;
    }

}
