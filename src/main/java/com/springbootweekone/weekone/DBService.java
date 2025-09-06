package com.springbootweekone.weekone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

  //  @Autowired
    private DB db;

    //constructor injection
    public DBService(DB db){
        this.db=db;
    }

    String getData(){
        return db.getData();
    }
}
