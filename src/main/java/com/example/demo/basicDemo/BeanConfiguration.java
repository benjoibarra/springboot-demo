package com.example.demo.basicDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {

    @Scope("prototype")
    @Bean("cat")
    public Cat getCat() {
        Cat catBean = new Cat();
        catBean.setName("Kitty");
        return catBean;
    }

}
