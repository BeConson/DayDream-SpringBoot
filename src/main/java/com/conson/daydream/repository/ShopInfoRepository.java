package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/2 21 : 33 : 34
 * @description 商品信息查询接口
 */
public interface ShopInfoRepository extends JpaRepository<ShopInfo,Integer> {
    public List<ShopInfo> findAllByCategoryType(Integer categoryType);
}
