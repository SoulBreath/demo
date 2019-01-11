package com.example.demo.mongodb.multiple.primary;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class PrimaryTemplate {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(){
        mongoTemplate.save(new User(2L,"小红","000000"));
    }
}
