package com.conson.daydream.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 康森
 * @date 2020/4/30 20 : 42 : 44
 * @description 商品规格实体
 */
@Data
@Entity
public class ShopSpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;
    private Integer shopId;
    private String specsName;
    private Integer specsStock;
    private BigDecimal specsPrice;
    private String specsIcon;
    private String specsPreview;
    private Date createTime;
    private Date updateTime;
}