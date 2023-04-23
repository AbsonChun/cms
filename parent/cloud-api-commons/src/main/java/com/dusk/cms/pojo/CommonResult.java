package com.dusk.cms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 前后端数据分离统一格式进行传参
 * @param <T>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //状态码
    private Integer code;
    //信息
    private String message;
    //传递的数据
    private T data;


    //有时候我们并不需要传递数据，因此我们可以设置一个data为空的构造方法
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
