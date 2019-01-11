package com.example.demo.mongodb.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 封装读取以MongoDB开头的两个配置文件
 */
@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {
    private MongoProperties primary = new MongoProperties();
    private MongoProperties secondary = new MongoProperties();
}
