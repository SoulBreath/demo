package com.example.demo.mongodb;

import com.example.demo.entity.User;
import com.example.demo.mongodb.repository.UserMongoRepository;
import com.example.demo.mongodb.template.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMongoDB {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMongoRepository userMongoRepository;

    /**
     * 保存
     */
    @Test
    public void testSaveUser(){
        User user = new User();
        user.setId(1L);
        user.setUsername("小明");
        user.setPassword("123456");
        userRepository.saveUser(user);
    }

    @Test
    public void testSave100User(){
        for (long i = 0; i<100; i++){
            User user = new User(i,"小明"+i,"99999999");
            userMongoRepository.save(user);
        }
    }

    /**
     * 查询
     */
    @Test
    public void findUserByUserName(){
        User user = userRepository.findUserByUserName("小明");
        User user1 = userMongoRepository.findByUsername("小明1");
        // User user2 = userMongoRepository.findByUsername("天空");
        List<User> users = userMongoRepository.findAllByUsername("天空");
        System.out.println("users are "+users);
    }

    /**
     * 更新
     */
    @Test
    public void updateUser(){
        User user = new User();
        user.setId(1L);
        user.setUsername("天空");
        user.setPassword("999999");
        userRepository.updateUser(user);

        User user2 = new User(2L,"天空","66666666");
        userMongoRepository.save(user2);
    }

    /**
     * 删除
     */
    @Test
    public void deleteUserById(){
        userRepository.deleteUserById(1L);
    }

    /**
     * 分页
     */
    @Test
    public void testPage(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(2, 10, sort);
        Page page = userMongoRepository.findAll(pageable);
        System.out.println("users: "+page.getContent().toString());
    }

}
