package com.example.demo.mongodb.multiple.primary;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PrimaryRepository extends MongoRepository<User, Long> {
}
