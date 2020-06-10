package com.conson.daydream.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author 康森
 * @date 2020/5/3 02 : 06 : 14
 * @description
 */
@Data
@AllArgsConstructor
public class ShopInfoVo {
    @JsonProperty("id")
    private Integer shopId;
    @JsonProperty("title")
    private String shopName;
    @JsonProperty("price")
    private String shopPrice;
    @JsonProperty("desc")
    private String shopDescription;
    private List<Map<String,String>> tag;
    @JsonProperty("thumb")
    private String shopIcon;
}
