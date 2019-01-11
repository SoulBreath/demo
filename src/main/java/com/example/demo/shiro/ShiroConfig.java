package com.example.demo.shiro;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * 注入自定义的realm
     */
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm = new MyRealm();
        logger.info("******myRealm注册完成******");
        return myRealm;
    }

    /**
     * 配置安全管理器SecurityManager
     */
    @Bean
    public SecurityManager securityManager(){
        // 将自定义的Realm加进来
        DefaultSecurityManager securityManager = new DefaultSecurityManager(myAuthRealm());
        logger.info("******securityManager注册完成******");
        return securityManager;
    }

    /**
     * 注入Shiro 过滤器
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        // 定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置自定义的securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置默认登录的URL, 身份认证失败会访问该URL
        shiroFilterFactoryBean.setLoginUrl("/login");

        // 设置成功只后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/success");

        // 设置未授权界面,权限认证失败会访问该URL
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        // LinkedHashMap 是有序的, 进行顺序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();

        // 配置可以匿名访问的地址,可以根据实际情况自己添加,放行一些静态资源等,anon表示放行
        filterChainMap.put("/css/**","anon");
        filterChainMap.put("/js/**","anon");
        filterChainMap.put("/img/**","anon");

        // 登录URL放行
        filterChainMap.put("/login/**","anon");

        // 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
        filterChainMap.put("/user/admin*", "authc");
        // “/user/student” 开头的用户需要角色认证，是“admin”才允许
        filterChainMap.put("/user/student*/**", "roles[admin]");
        // “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
        filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");

        // 配置 logout 过滤器
        filterChainMap.put("/logout", "logout");

        // 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        logger.info("====shiroFilterFactoryBean注册完成====");
        return shiroFilterFactoryBean;
    }
}
