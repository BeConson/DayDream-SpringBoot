package com.conson.daydream.vo.specs_package_vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 康森
 * @date 2020/5/4 14 : 23 : 22
 * @description
 */
@Data
public class ShopSpecsCasVo {
    @JsonProperty("s1")
    private Integer specsId;
    @JsonProperty("price")
    private BigDecimal specsPrice;
    @JsonProperty("stock_num")
    private Integer specsStock;
}
