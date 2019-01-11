package com.example.demo.mongodb.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 创建Multiple
 */
@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;


    /**
     * 利用上面构建好的MongoDbFactory创建对应的MongoTemplate
     */
    @Bean(name = "primaryMongoTemplate")
    @Primary
    public MongoTemplate primaryMongoTemplate(){
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }



    /**
     * 构建第二个数据源的MongoTemplate
     */
    @Bean
    @Qualifier
    public MongoTemplate secondaryMongoTemplate(){
        return new MongoTemplate(secondaryFactory(this.mongoProperties.getSecondary()));
    }

    /**
     * 根据配置文件信息构建第一个数据源的MongoDbFactory
     */
    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo){
        MongoClient client = new MongoClient(new MongoClientURI(mongo.getUri()));
        return new SimpleMongoDbFactory(client, mongo.getDatabase());
    }

    /**
     * 构建第二个数据源的MongoDbFactory
     */
    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongo){
        MongoClient client = new MongoClient(new MongoClientURI(mongo.getUri()));
        return new SimpleMongoDbFactory(client, mongo.getDatabase());
    }
}
