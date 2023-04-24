package com.dusk.user.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {

    public static Subject getSubject(String path) {
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory(path);
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        return SecurityUtils.getSubject();
    }

    public static Subject login(String path, String userName, String passWord) {
        Subject subject = getSubject(path);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            System.out.println("无效的用户名");
            e.printStackTrace();
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码错误");
            e.printStackTrace();
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        //subject.logout();
        //System.out.println("退出成功");
        return subject;
    }
}

