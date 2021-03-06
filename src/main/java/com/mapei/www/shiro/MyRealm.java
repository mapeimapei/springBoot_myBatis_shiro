package com.mapei.www.shiro;

import com.mapei.www.dao.UserServiceDao;
import com.mapei.www.entity.User;
import com.mapei.www.util.JWTUtil;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    @Autowired
    UserServiceDao userServiceDao;
    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String email = JWTUtil.getUsername(principals.toString());
        User user = userServiceDao.getUser(email);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getAdmin());
//        Set<String> permission = new HashSet<>(Arrays.asList(user.getPermission().split(",")));
//        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String email = JWTUtil.getUsername(token);
        if (email == null) {
            throw new AuthenticationException("token invalid");
        }

        User user = userServiceDao.getUser(email);
        if (user == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, email, user.getPasswd())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
