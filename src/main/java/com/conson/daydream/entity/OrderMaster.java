package com.conson.daydream.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 康森
 * @description 订单实体类
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class OrderMaster {
    @Id
    private String orderId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private Integer shopId;
    private String shopName;
    private Integer shopQuantity;
    private String shopIcon;
    private Integer specsId;
    private String specsName;
    private BigDecimal specsPrice;
    private BigDecimal orderAmount;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;
}