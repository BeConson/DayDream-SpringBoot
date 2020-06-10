package com.conson.daydream.service.impl;

import com.conson.daydream.service.ShopService;
import com.conson.daydream.vo.DataVo;
import com.conson.daydream.vo.ShopInfoVo;
import com.conson.daydream.vo.specs_package_vo.SpecsPackageVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopServiceImplTest {

    @Autowired
    private ShopService shopService;

    @Test
    void findDataVo(){
        DataVo dataVo = shopService.findDataVo();
        int id = 0;
    }

    @Test
    void findShopInfoVoByCategoryType(){
        List<ShopInfoVo> list = shopService.findShopInfoVoByCategoryType(2);
        int id = 0;
    }

    @Test
    void findSku(){
        SpecsPackageVo specsPackageVo = shopService.findSpecsPackageVoByShopId(1);
        int id = 0;
    }

    @Test
    void subStock(){
        shopService.subStock(1,1);
    }

}