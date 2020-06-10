package com.conson.daydream.repository;

import com.conson.daydream.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository masterRepository;

    @Test
    void findAll(){
        List<OrderMaster> list = masterRepository.findAll();
        for (OrderMaster OrderMaster : list){
            System.out.println(OrderMaster);
        }
    }

    @Test
    void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setUserName("可可");
        orderMaster.setUserPhone("333");
        orderMaster.setUserAddress("太空");
        orderMaster.setShopId(2);
        orderMaster.setShopName("康森大大");
        orderMaster.setShopQuantity(13);
        orderMaster.setShopIcon("vvvvv");
        orderMaster.setSpecsId(2);
        orderMaster.setSpecsName("ks");
        orderMaster.setSpecsPrice(new BigDecimal(200));
        orderMaster.setOrderAmount(new BigDecimal(50));
        orderMaster.setPayStatus(2);
        masterRepository.save(orderMaster);
    }

    @Test
    void findById(){
        OrderMaster orderMaster = masterRepository.findById("2").get();
        System.out.println(orderMaster);
    }

    @Test
    void pay(){
        OrderMaster orderMaster = masterRepository.findById("2").get();
        orderMaster.setPayStatus(1);
        masterRepository.save(orderMaster);
    }
}