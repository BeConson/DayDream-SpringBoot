package com.conson.daydream.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/3 01 : 57 : 47
 * @description
 */
@Data
public class DataVo {
    private List<ShopCategoryVo> categories;
    private List<ShopInfoVo> shop;
}
