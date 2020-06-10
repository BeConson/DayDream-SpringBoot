package com.conson.daydream.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author 康森
 * @date 2020/5/2 21 : 58 : 20
 * @description 信息校验
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名不能为空哦")
    private String name;
    @NotEmpty(message = "电话不能为空哦")
    private String tel;
    @NotEmpty(message = "地址不能为空哦")
    private String address;
    @NotNull(message = "类型不能为空哦")
    private Integer specsId;
    @NotNull(message = "数量不能为空哦")
    private Integer quantity;
}