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
 * @date 2020/5/2 21 : 24 : 45
 * @description 商品信息实体
 */
@Data
@Entity
public class ShopInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer shopId;
    private String shopName;
    private BigDecimal shopPrice;
    private String shopDescription;
    private Integer shopStock;
    private String shopIcon;
    private Integer categoryType;
    private String shopTag;
    private Date createTime;
    private Date updateTime;

}
