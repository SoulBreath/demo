package com.example.demo.mongodb.multiple.secondary;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SecondaryRepository extends MongoRepository<User, Long> {
}
