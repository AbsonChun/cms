package com.dusk.user.service;

import com.dusk.user.domain.User;
import com.dusk.user.enums.LoginEnum;
import com.dusk.user.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {


    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> checkUserByLoginNameAndPassword(String loginName,String password){
        Map<String,Object> returnMap = new HashMap<>();
        User user = userMapper.getByLoginName(loginName);
        if (user !=null){
            if(StringUtils.isNotBlank(password)){
                System.out.println("----->>user.getPassword()====" + user.getPassword());
                System.out.println("----->>password====" + password);
                if (password.equals(user.getPassword())){
                    returnMap.put("code", LoginEnum.LoginStatus.SUCCESS.getCode());
                    returnMap.put("message",LoginEnum.LoginStatus.SUCCESS.getValue());
                    returnMap.put("user",user);
                }else{
                    returnMap.put("code",LoginEnum.LoginStatus.INCORRECT_CREDENTIALS.getCode());
                    returnMap.put("message",LoginEnum.LoginStatus.INCORRECT_CREDENTIALS.getValue());
                }
            }else{
                returnMap.put("code",LoginEnum.LoginStatus.INCORRECT_CREDENTIALS.getCode());
                returnMap.put("message",LoginEnum.LoginStatus.INCORRECT_CREDENTIALS.getValue());
            }
        }else{
            returnMap.put("code",LoginEnum.LoginStatus.UNKNOW_ACCOUNT.getCode());
            returnMap.put("message",LoginEnum.LoginStatus.UNKNOW_ACCOUNT.getValue());
        }
        return returnMap;
    }
}
