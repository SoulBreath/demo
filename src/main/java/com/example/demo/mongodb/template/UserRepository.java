package com.example.demo.mongodb.template;

import com.example.demo.entity.User;

public interface UserRepository {

    void saveUser(User user);

    // 根据username查询USER;
    User findUserByUserName(String username);

    long updateUser(User user);

    void deleteUserById(Long id);
}
