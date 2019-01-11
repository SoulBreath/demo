package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.Set;

public interface UserService {

    // 获取用户角色
    Set<String> getRoles(String username);

    // 获取用户权限
    Set<String> getPermissions(String username);

    // 获取用户
    User getByUsername(String username);
}
