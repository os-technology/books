package com.boot.group.dict.service.impl;

import com.boot.group.dict.entity.User;
import com.boot.group.dict.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author code
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/10/10上午11:06
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    /**
     * 用户的登录功能
     *
     * @param map
     * @return
     */
    @Override
    public boolean login(Map map) {
        String username = (String) map.get("loginName");
        String password = (String) map.get("password");
        if (!"shiro".equals(username)) {
            return false;
        }
        if (!"pass".equals(password)) {
            return false;
        }
        User user = new User();
        user.setUsername(username)
                .setPassword(password);

        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword()); // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            return false;
        } catch (IncorrectCredentialsException ice) {
            return false;
        } catch (LockedAccountException lae) {
            return false;
        } catch (ExcessiveAttemptsException eae) {
            return false;
        } catch (AuthenticationException ae) {
            ae.printStackTrace();
            return false;
        }
        // 验证是否登录成功
        if (currentUser.isAuthenticated()) {

            System.out.println("登录成功");
            return true;
        } else {
            token.clear();
            System.out.println("请重新登录");
            return false;
        }
    }

}
