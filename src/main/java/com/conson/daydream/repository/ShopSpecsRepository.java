package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/2 21 : 47 : 48
 * @description 商品规格查询接口
 */
public interface ShopSpecsRepository extends JpaRepository<ShopSpecs,Integer> {
    public List<ShopSpecs> findAllByShopId(Integer shopId);
}
