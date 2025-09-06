package com.springbootweekone.weekone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope("singleton")//creating one object of apple
   // @Scope("prototype")//creating two object of apple
    Apple getApple(){
        return new Apple();
    }
}
