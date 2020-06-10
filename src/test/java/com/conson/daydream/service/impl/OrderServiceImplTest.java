package com.conson.daydream.service.impl;

import com.conson.daydream.dto.OrderDTO;
import com.conson.daydream.service.OrderService;
import com.conson.daydream.vo.OrderDetailVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void createOrder(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserName("con");
        orderDTO.setUserPhone("123456789");
        orderDTO.setUserAddress("火星");
        orderDTO.setSpecsId(1);
        orderDTO.setShopQuantity(1);

        OrderDTO result = orderService.createOrder(orderDTO);
        System.out.println(result);
    }

    @Test
    void findDetail(){
        OrderDetailVo orderDetailVo = orderService.findOrderDetailByOrderId("1588602083662829358");
        int id = 10;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1588602083662829358"));
    }

    @Test
    void findAllOrder(){
        System.out.println(orderService.findAllOrder());
    }

    @Test
    void deleteOrder() {
        orderService.deleteOrder("1588985927048186802");
    }
}