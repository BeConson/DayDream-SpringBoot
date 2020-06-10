package com.conson.daydream.service;

import com.conson.daydream.vo.DataVo;
import com.conson.daydream.vo.ShopInfoVo;
import com.conson.daydream.vo.specs_package_vo.SpecsPackageVo;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/3 01 : 55 : 35
 * @description 商品业务
 */
public interface ShopService {
    public DataVo findDataVo();
    public List<ShopInfoVo> findShopInfoVoByCategoryType(Integer categoryType);
    public SpecsPackageVo findSpecsPackageVoByShopId(Integer shopId);
    public void subStock(Integer specsId,Integer quantity);
}
