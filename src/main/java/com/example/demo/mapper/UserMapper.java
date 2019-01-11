package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

@Mapper
public interface UserMapper {

    // 获取用户角色
    Set<String> getRoles(@Param("username") String username);

    // 获取用户权限
    Set<String> getPermissions(@Param("username") String username);

    // 获取用户
    User getByUsername(@Param("username") String username);
}
