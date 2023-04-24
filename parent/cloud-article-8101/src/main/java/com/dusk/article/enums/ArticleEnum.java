package com.dusk.article.enums;

import com.dusk.common.enums.BaseEnum;

/**
 * 登录枚举
 */
public class ArticleEnum {

    public enum ArticleStatus implements BaseEnum<ArticleStatus> {

        ARTICLE_STATUS_NORMAL("0","验证通过！"),
        ARTICLE_STATUS_DISABLE("1","无效的用户名！");
        private String code;
        private String value;

        ArticleStatus(String code,String value){
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
