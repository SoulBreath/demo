package com.example.demo.mongodb;

import com.example.demo.entity.User;
import com.example.demo.mongodb.multiple.primary.PrimaryRepository;
import com.example.demo.mongodb.multiple.primary.PrimaryTemplate;
import com.example.demo.mongodb.multiple.secondary.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleMongoTest {

    @Autowired
    private PrimaryRepository primaryRepository;
    @Autowired
    private SecondaryRepository secondaryRepository;

    @Autowired
    private PrimaryTemplate primaryTemplate;

    @Test
    public void save2(){
        primaryTemplate.save();
    }


    @Test
    public void save(){
        primaryRepository.save(new User(1L,"小张","123456"));
        secondaryRepository.save(new User(2L,"小王","456789"));

        List<User> primaries = primaryRepository.findAll();
        for (User primary : primaries){
            System.out.println(primary.toString());
        }

        List<User> secondaries = secondaryRepository.findAll();
        for (User secondary : secondaries){
            System.out.println(secondary.toString());
        }
    }
}
