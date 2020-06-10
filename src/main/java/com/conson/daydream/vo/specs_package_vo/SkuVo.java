package com.conson.daydream.vo.specs_package_vo;

import lombok.Data;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/4 14 : 00 : 57
 * @description
 */
@Data
public class SkuVo {
    private List<TreeVo> tree;
    private List<ShopSpecsCasVo> list;
    private String price;
    private Integer stock_num;
    private boolean none_sku = false;
    private boolean hide_stock = false;



}
