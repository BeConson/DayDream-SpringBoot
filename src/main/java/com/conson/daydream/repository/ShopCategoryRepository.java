package com.conson.daydream.repository;

import com.conson.daydream.entity.ShopCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 康森
 * @date 2020/4/30 20 : 48 : 19
 * @description 商品分类查询接口
 */
public interface ShopCategoryRepository extends JpaRepository<ShopCategory,Integer> {
    public ShopCategory findByCategoryType(Integer categoryType);
}
