package com.dusk.user.service.impl;

import com.dusk.common.enums.ResultEnum;
import com.dusk.user.domain.User;
import com.dusk.user.mapper.UserMapper;
import com.dusk.user.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    public Map<String, Object> checkUserByLoginNameAndPassword(String loginName, String password) {
        Map<String, Object> returnMap = new HashMap<>();
        User user = userMapper.getByLoginName(loginName);
        if (user != null) {
            if (StringUtils.isNotBlank(password)) {
                System.out.println("----->>user.getPassword()====" + user.getPassword());
                System.out.println("----->>password====" + password);
                if (password.equals(user.getPassword())) {
                    returnMap.put("code", ResultEnum.ResultCode.SUCCESS.getCode());
                    returnMap.put("message", ResultEnum.ResultCode.SUCCESS.getValue());
                    returnMap.put("user", user);
                } else {
                    returnMap.put("code", ResultEnum.ResultCode.INCORRECT_CREDENTIALS.getCode());
                    returnMap.put("message", ResultEnum.ResultCode.INCORRECT_CREDENTIALS.getValue());
                }
            } else {
                returnMap.put("code", ResultEnum.ResultCode.INCORRECT_CREDENTIALS.getCode());
                returnMap.put("message", ResultEnum.ResultCode.INCORRECT_CREDENTIALS.getValue());
            }
        } else {
            returnMap.put("code", ResultEnum.ResultCode.USERNAME_EXIST_ERROR.getCode());
            returnMap.put("message", ResultEnum.ResultCode.USERNAME_EXIST_ERROR.getValue());
        }
        return returnMap;
    }
}
