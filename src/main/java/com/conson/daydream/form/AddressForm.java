package com.conson.daydream.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author 康森
 * @date 2020/5/4 19 : 40 : 56
 * @description 用于接受前端传来的数据
 */
@Data
public class AddressForm {
    private Integer id;
    @NotEmpty(message = "姓名不能为空哦")
    private String name;
    @NotEmpty(message = "电话不能为空哦")
    private String tel;
    @NotEmpty(message = "省不能为空哦")
    private String province;
    @NotEmpty(message = "市不能为空哦")
    private String city;
    @NotEmpty(message = "区不能为空哦")
    private String county;
    @NotEmpty(message = "编码不能为空哦")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空哦")
    private String addressDetail;
}
