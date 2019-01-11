package com.example.demo.redis;

import com.example.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedisTemplate {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> valueOperations;
    @Resource(name = "redisTemplate")
    private HashOperations<String, String, Object> hashOperations;
    @Resource(name = "redisTemplate")
    private ListOperations<String, Object> listOperations;
    @Resource(name = "redisTemplate")
    private SetOperations<String, Object> setOperations;
    @Resource(name = "redisTemplate")
    private ZSetOperations<String, Object> zSetOperations;

    public TestRedisTemplate() {

    }


    @Test
    public void testString(){
        redisTemplate.opsForValue().set("neo","itYouKnow");
        Assert.assertEquals("itYouKnow", redisTemplate.opsForValue().get("neo"));
    }

    @Test
    public void testObj(){
        User user = new User(1L,"user1","123456");
        valueOperations.set("user",user);
        User u = (User) valueOperations.get("user");
        assert u != null;
        System.out.println(u.toString());
    }

    @Test
    public void testExpire() throws InterruptedException {
        User user = new User(1L,"user1","123456");
        valueOperations.set("expire",user,100, TimeUnit.MILLISECONDS);
        Thread.sleep(95);
        boolean exists = redisTemplate.hasKey("expire");
        if (exists){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    @Test
    public void testDelete(){
        valueOperations.set("delete","徐阳");
        redisTemplate.delete("delete");
        boolean exists=redisTemplate.hasKey("delete");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }

    @Test
    public void testHash(){
        hashOperations.put("hash","you","you");
        String value = (String) hashOperations.get("hash","you");
        System.out.println("hash value: "+value);
    }

    @Test
    public void testList(){
        listOperations.leftPush("list","it");
        listOperations.leftPush("list","you");
        listOperations.leftPush("list","know");

        System.out.println(listOperations.rightPop("list"));
    }

    @Test
    public void testSeT(){
        String key = "sets";
        setOperations.add(key,"it");
        setOperations.add(key,"you");
        setOperations.add(key,"you");
        setOperations.add(key,"know");
        Set<Object> values = setOperations.members(key);
        for (Object o : values){
            System.out.println("set value : "+ o);
        }
    }
}
