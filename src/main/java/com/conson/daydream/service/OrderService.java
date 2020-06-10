package com.conson.daydream.service;

import com.conson.daydream.dto.OrderDTO;
import com.conson.daydream.entity.OrderMaster;
import com.conson.daydream.entity.ShopInfo;
import com.conson.daydream.vo.OrderDetailVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/4 21 : 13 : 49
 * @description 用户订单业务
 */
@Service
public interface OrderService {
    public OrderDTO createOrder(OrderDTO orderDTO);
    public OrderDetailVo findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
    public List<OrderMaster> findAllOrder();
    public void deleteOrder(String id);
}
