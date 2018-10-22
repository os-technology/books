package com.boot.group.dict.shiro;

import com.boot.group.dict.entity.User;
import com.boot.group.util.Md5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author code
 * @Title: MyShiroRealm
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/9下午3:05
 */
public class MyShiroRealm extends AuthorizingRealm {
    /**
     * 授权用户权限
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        //获取用户角色
        Set<String> roleSet = new HashSet<String>();
        roleSet.add("100002");
        info.setRoles(roleSet);

        //获取用户权限
        Set<String> permissionSet = new HashSet<String>();
        permissionSet.add("权限添加");
        permissionSet.add("权限删除");
        info.setStringPermissions(permissionSet);


        return info;

    }

    /**
     * 验证用户身份
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("nickname", username);
        //密码进行加密处理  明文为  password+name
//        String paw = password+username;
        String pawDES = Md5Util.MD5Encode(password);
//        map.put("pswd", password);

        User user = new User();
//        user.setId(112222L);
        user.setUsername(username);
        user.setPassword(password);

//注意，数据库中的user的密码必须是要经过md5加密，不然还是会抛出异常！！！！！
        return new SimpleAuthenticationInfo(user, pawDES, getName());


    }
}
