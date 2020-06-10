package com.conson.daydream.dto;

import lombok.Data;

/**
 * @author 康森
 * @date 2020/5/4 21 : 21 : 51
 * @description
 */
@Data
public class OrderDTO {
    private String orderId;
    private String userName;
    private String userPhone;
    private String userAddress;
    private Integer specsId;
    private Integer shopQuantity;
}
