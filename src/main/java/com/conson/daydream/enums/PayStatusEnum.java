package com.conson.daydream.enums;

import lombok.Getter;

/**
 * @author 康森
 * @date 2020/5/4 22 : 00 : 28
 * @description 支付状态码
 */
@Getter
public enum  PayStatusEnum {
    /***/
    UN_PAY(0,"未支付"),
    PAY(1,"已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
