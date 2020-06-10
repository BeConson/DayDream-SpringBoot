package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ShopCategoryRepositoryTest {

    @Autowired
    private ShopCategoryRepository repository;

    @Test
    void findAll(){
        List<ShopCategory> list = repository.findAll();
        for (ShopCategory shopCategory : list){
            System.out.println(shopCategory);
        }
    }

//    @Test
//    void findByCategoryType(){
//        ShopCategory shopCategory = repository.findByCategoryType(1);
//        System.out.println(shopCategory);
//    }

}