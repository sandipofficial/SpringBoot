package com.codingshuttle.sandip.week1introduction.IntroductionToSpringboot;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class Apple {
    void eatApple(){
        System.out.println("i'm eating the apple");
    }

    @PostConstruct
    void callThisBesforeAppleUsed(){
        System.out.println("Creating the apple before use");
    }
    @PreDestroy
    void callThisBeforeDestroy(){
        System.out.println("Destroying the apple bean");
    }
}
