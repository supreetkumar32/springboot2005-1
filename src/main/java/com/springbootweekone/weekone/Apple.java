package com.springbootweekone.weekone;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;


public class Apple {
    public void eat(){
        System.out.println("i am eating the apple");
    }

    //this method to be called when we are creating the object of Apple class
    //dependency injection ke turant baad call hota hai
    @PostConstruct
    void callThisBeforeAppleIsUsed(){
        System.out.println("creating the apple before use");
    }

    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying the Apple bean");
    }
}
