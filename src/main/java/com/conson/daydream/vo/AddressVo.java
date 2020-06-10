package com.conson.daydream.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 康森
 * @date 2020/5/4 19 : 24 : 33
 * @description
 */
@Data
@AllArgsConstructor
public class AddressVo {
    private Integer id;
    private String areaCode;
    private String name;
    private String tel;
    private String address;
}
