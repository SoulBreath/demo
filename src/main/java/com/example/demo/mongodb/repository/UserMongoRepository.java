package com.example.demo.mongodb.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserMongoRepository extends MongoRepository<User,Long> {
    User findByUsername(String username);
    List<User> findAllByUsername(String username);
    Page<User> findAll(Pageable var);
}
