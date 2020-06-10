package com.conson.daydream.vo.specs_package_vo;

import lombok.Data;

import java.util.Map;

/**
 * @author 康森
 * @date 2020/5/4 13 : 59 : 37
 * @description
 */
@Data
public class SpecsPackageVo {
    private Map<String,String> goods;
    private SkuVo sku;
}
