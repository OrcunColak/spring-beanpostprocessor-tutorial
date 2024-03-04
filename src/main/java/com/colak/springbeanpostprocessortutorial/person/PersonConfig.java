package com.colak.springbeanpostprocessortutorial.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    // This will cause .BeanCreationException
    @Bean
    public Person getInstance() {
        return new Person("Person", 111);
    }

}
