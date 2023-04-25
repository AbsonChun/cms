package com.dusk.user.enums;

import com.dusk.common.enums.BaseEnum;

public class MenuEnum {

    public enum MenuStatus implements BaseEnum<MenuStatus> {

        MENU_STATUS_NORMAL("1", "启用"),
        MENU_STATUS_DISABLE("0", "禁用");
        private String code;
        private String value;

        MenuStatus(String code, String value) {
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

    public enum MenuLevel implements BaseEnum<MenuLevel> {

        MENU_LEVEL_ONE("1", "1"),
        MENU_LEVEL_TWO("2", "2"),
        MENU_LEVEL_THREE("3", "3"),
        ;
        private String code;
        private String value;

        MenuLevel(String code, String value) {
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
