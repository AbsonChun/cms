package com.dusk.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dusk.user.domain.Permission;
import com.dusk.user.domain.Role;
import com.dusk.user.domain.User;

import java.util.Set;

/**
 * @Entity generator..User
 */
public interface UserMapper extends BaseMapper<User> {

    User getById(Integer id);

    User getByLoginName(String loginName);

    Set<Role> getRoleSetByUserId(Integer userId);

    Set<Permission> getPermissionSetByUserId(Integer userId);

}




