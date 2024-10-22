package com.codingshuttle.sandip.week1introduction.IntroductionToSpringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

//    @Autowired   // field injection
    final private DB db;   // this is to make constructor immutable

    public DBService(DB db){     // constructor injection
        this.db = db;
    }
    


    String getData(){
        return db.getData();
    }
}
