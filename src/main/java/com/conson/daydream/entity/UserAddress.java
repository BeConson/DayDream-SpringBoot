package com.conson.daydream.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 康森
 * @date 2020/5/2 21 : 58 : 20
 * @description 用户地址实体
 */

@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String areaCode;
    private Date createTime;
    private Date updateTime;
}
