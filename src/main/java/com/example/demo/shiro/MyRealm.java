package com.example.demo.shiro;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 用来验证当前登录的用户，获取认证信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给该用户设置角色,角色信息在 t_role 表中取
        authorizationInfo.setRoles(userService.getRoles(username));
        // 给该用户设置权限, 权限信息在 t_permissions 表中取
        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 根据token获取用户名
        String username = (String) authenticationToken.getPrincipal();
        // 根据用户名从数据库中查询该用户
        User user = userService.getByUsername(username);
        if (user != null){
            // 把当前用户存到Session中
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            // 传入用户名和密码进行身份认证,并返回认证信息
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");
            return authcInfo;
        }else {
            return null;
        }
    }
}
