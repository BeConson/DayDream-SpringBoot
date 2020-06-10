package com.conson.daydream.exception;

import com.conson.daydream.enums.ResultEnum;

/**
 * @author 康森
 * @date 2020/5/4 18 : 50 : 57
 * @description 异常处理
 */
public class ShopException extends RuntimeException{
    public ShopException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
    }

    public ShopException(String error){
        super(error);
    }
}
