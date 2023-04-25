package com.dusk.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dusk.user.domain.Permission;
import com.dusk.user.domain.Role;
import com.dusk.user.domain.User;
import com.dusk.user.mapper.UserMapper;
import com.dusk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getById(Integer id) {
        return userMapper.getById(id);
    }

    public Set<Role> getRoleSetByUserId(Integer userId) {
        return userMapper.getRoleSetByUserId(userId);
    }

    public Set<Permission> getPermissionSetByUserId(Integer userId) {
        return userMapper.getPermissionSetByUserId(userId);
    }
}




