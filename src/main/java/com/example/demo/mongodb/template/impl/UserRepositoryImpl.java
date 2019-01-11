package com.example.demo.mongodb.template.impl;

import com.example.demo.entity.User;
import com.example.demo.mongodb.template.UserRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserRepositoryImpl  implements UserRepository  {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user){
        mongoTemplate.save(user);
    }

    @Override
    public User findUserByUserName(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public long updateUser(User user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("username",user.getUsername()).set("password",user.getPassword());
        // 更新查询返回结果集的第一条
        UpdateResult result = mongoTemplate.updateFirst(query,update,User.class);
        // 更新查询返回结果集的所有
        // mongoTemplate.updateMulti(query,update,User.class);
        if (result != null){
            return result.getMatchedCount();
        }else {
            return 0;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,User.class);
    }

}
