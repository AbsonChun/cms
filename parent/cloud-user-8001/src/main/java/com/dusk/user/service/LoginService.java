package com.dusk.user.service;

import java.util.Map;

/**
 *
 */
public interface LoginService {

    public Map<String, Object> checkUserByLoginNameAndPassword(String loginName, String password);
}
