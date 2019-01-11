package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Set<String> getRoles(String username) {
        return userMapper.getRoles(username);
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userMapper.getPermissions(username);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
