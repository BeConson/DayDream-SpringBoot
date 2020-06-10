package com.conson.daydream.vo;

import lombok.Data;

/**
 * @author 康森
 * @date 2020/5/5 21 : 41 : 31
 * @description
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String  msg;
    private T data;
}
