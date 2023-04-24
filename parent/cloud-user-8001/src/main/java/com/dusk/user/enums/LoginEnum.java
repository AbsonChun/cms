package com.dusk.user.enums;

import com.dusk.common.enums.BaseEnum;

/**
 * 登录枚举
 */
public class LoginEnum {

    public enum LoginStatus implements BaseEnum<LoginStatus> {

        SUCCESS("200","验证通过！"),
        UNKNOW_ACCOUNT("300","无效的用户名！"),
        INCORRECT_CREDENTIALS("400","用户名或密码输入有误！");
        private String code;
        private String value;

        LoginStatus(String code,String value){
            this.code = code;
            this.value = value;
        }

        @Override
        public String getCode() {
            return this.code;
        }
        @Override
        public String getValue() {
            return this.value;
        }
    }
}
