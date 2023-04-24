package com.dusk.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dusk.user.domain.User;
import com.dusk.user.domain.Role;
import com.dusk.user.domain.Permission;

import java.util.Set;

/**
 *
 */
public interface UserService extends IService<User> {


    User getById(Integer id);

    Set<Role> getRoleSetByUserId(Integer userId);

    Set<Permission> getPermissionSetByUserId(Integer userId);

}
