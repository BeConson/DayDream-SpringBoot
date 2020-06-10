package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ShopSpecsRepositoryTest {

    @Autowired
    private ShopSpecsRepository specsRepository;

    @Test
    void findAll(){
        List<ShopSpecs> list = specsRepository.findAll();
        for (ShopSpecs shopSpecs : list) {
            System.out.println(shopSpecs);
        }
    }

//    @Test
//    void findAllByShopId(){
//        List<ShopSpecs> list = specsRepository.findAllByShopId(1);
//        for (ShopSpecs shopSpecs : list) {
//            System.out.println(shopSpecs);
//        }
//    }
}