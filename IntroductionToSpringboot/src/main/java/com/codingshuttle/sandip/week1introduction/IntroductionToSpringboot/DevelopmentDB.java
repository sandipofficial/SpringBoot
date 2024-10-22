package com.codingshuttle.sandip.week1introduction.IntroductionToSpringboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

@ConditionalOnProperty(name = "deploy.env", havingValue = "development")
public class DevelopmentDB implements DB {
    public String getData(){
        return "Dev Data";
    }
}
