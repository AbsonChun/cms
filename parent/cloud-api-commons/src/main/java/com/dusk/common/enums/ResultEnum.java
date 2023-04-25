package com.dusk.common.enums;

public class ResultEnum {

    public enum ResultCode implements BaseEnum<ResultCode> {
        //常规错误
        SUCCESS("200", "数据响应成功"),

        USERNAME_EXIST_ERROR("301", "用户名不存在"),
        INCORRECT_CREDENTIALS("302", "用户名或密码输入有误！"),
        UNAUTHORIZED("303", "用户未授权"),

        BAD_REQUEST("400", "错误的请求"),

        //参数
        FIELD_VALIDATE_FAIL("1001", "参数校验失败"),

        UNKNOWN_EXCEPTION("500", "未知异常");

        private String code;
        private String value;

        ResultCode(String code, String value) {
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
