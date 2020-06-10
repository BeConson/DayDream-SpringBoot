package com.conson.daydream.enums;

import lombok.Getter;

/**
 * @author 康森
 * @date 2020/5/4 18 : 53 : 09
 * @description 枚举类信息
 */
@Getter
public enum ResultEnum {
    /***/
    SHOP_STOCK_ERROR(0,"商品库存不足啦"),
    ORDER_NOT_EXIST(1,"订单不存在哦"),
    SPECS_NOT_EXIST(2,"类型不存在哦"),
    SHOP_NOT_EXIST(3,"商品不存在哦"),
    ORDER_PAY(4,"订单已经支付过了哦");


    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
