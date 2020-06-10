package com.conson.daydream.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 康森
 * @date 2020/5/3 02 : 00 : 41
 * @description
 */
@Data
@AllArgsConstructor
public class ShopCategoryVo {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}
