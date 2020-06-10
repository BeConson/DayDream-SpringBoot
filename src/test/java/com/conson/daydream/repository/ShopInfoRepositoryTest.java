package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ShopInfoRepositoryTest {

    @Autowired
    private ShopInfoRepository infoRepository;

    @Test
    void findAll(){
        List<ShopInfo> list  = infoRepository.findAll();
        for (ShopInfo shopInfo : list) {
            System.out.println(shopInfo);
        }
    }

    @Test
    void findAllByCategoryType(){
        List<ShopInfo> list  = infoRepository.findAllByCategoryType(1);
        for (ShopInfo shopInfo : list) {
            System.out.println(shopInfo);
        }
    }
}