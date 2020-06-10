package com.conson.daydream.service.impl;

import com.conson.daydream.entity.ShopCategory;
import com.conson.daydream.entity.ShopInfo;
import com.conson.daydream.entity.ShopSpecs;
import com.conson.daydream.enums.ResultEnum;
import com.conson.daydream.exception.ShopException;
import com.conson.daydream.repository.ShopCategoryRepository;
import com.conson.daydream.repository.ShopInfoRepository;
import com.conson.daydream.repository.ShopSpecsRepository;
import com.conson.daydream.service.ShopService;
import com.conson.daydream.util.ShopUtil;
import com.conson.daydream.vo.DataVo;
import com.conson.daydream.vo.ShopCategoryVo;
import com.conson.daydream.vo.ShopInfoVo;
import com.conson.daydream.vo.specs_package_vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 康森
 * @date 2020/5/3 15 : 12 : 47
 * @description 商品业务实现
 */
@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopCategoryRepository shopCategoryRepository ;

    @Autowired
    private ShopInfoRepository shopInfoRepository;

    @Autowired
    private ShopSpecsRepository shopSpecsRepository;

    @Override
    public DataVo findDataVo() {
        DataVo dataVo = new DataVo();
        //类型 ↓
        List<ShopCategory> shopCategoryList = shopCategoryRepository.findAll();
  
        List<ShopCategoryVo> shopCategoryVoList = shopCategoryList.stream().map( e -> new ShopCategoryVo(
                e.getCategoryName(),
                e.getCategoryType()
        )).collect(Collectors.toList());

        dataVo.setCategories(shopCategoryVoList);

        //商品 ↓
        List<ShopInfo> shopInfoList =
                shopInfoRepository.
                        findAllByCategoryType(shopCategoryList.get(0).getCategoryType());

        List<ShopInfoVo> shopInfoVos = new ArrayList<>();

        //stream流
        List<ShopInfoVo> shopInfoVoList = shopInfoList.stream().map( e -> new ShopInfoVo(
                e.getShopId(),
                e.getShopName(),
                e.getShopPrice()+".00",
                e.getShopDescription(),
                ShopUtil.createTag(e.getShopTag()),
                e.getShopIcon()
                )).collect(Collectors.toList());
        dataVo.setShop(shopInfoVoList);
        return dataVo;
    }

    @Override
    public List<ShopInfoVo> findShopInfoVoByCategoryType(Integer categoryType) {
        List<ShopInfo> shopInfoList = shopInfoRepository.findAllByCategoryType(categoryType);
        List<ShopInfoVo> shopInfoVoList = shopInfoList.stream()
                .map( e -> new ShopInfoVo(
                        e.getShopId(),
                        e.getShopName(),
                        e.getShopPrice()+".00",
                        e.getShopDescription(),
                        ShopUtil.createTag(e.getShopTag()),
                        e.getShopIcon()
                        )).collect(Collectors.toList());

        return shopInfoVoList;
    }

    @Override
    public SpecsPackageVo findSpecsPackageVoByShopId(Integer shopId) {
        ShopInfo shopInfo = shopInfoRepository.findById(shopId).get();
        List<ShopSpecs> shopSpecsList = shopSpecsRepository.findAllByShopId(shopId);
        //封装tree
        List<ShopSpecsVo> shopSpecsVoList = new ArrayList<>();
        List<ShopSpecsCasVo> shopSpecsCasVoList = new ArrayList<>();
        ShopSpecsVo shopSpecsVo;
        ShopSpecsCasVo shopSpecsCasVo;
        for (ShopSpecs shopSpecs : shopSpecsList) {
            shopSpecsVo = new ShopSpecsVo();
            shopSpecsCasVo = new ShopSpecsCasVo();
            BeanUtils.copyProperties(shopSpecs,shopSpecsVo);
            BeanUtils.copyProperties(shopSpecs,shopSpecsCasVo);
            shopSpecsVoList.add(shopSpecsVo);
            shopSpecsCasVoList.add(shopSpecsCasVo);
        }
        TreeVo treeVo = new TreeVo();
        treeVo.setV(shopSpecsVoList);
        List<TreeVo> treeVoList = new ArrayList<>();
        treeVoList.add(treeVo);

        SkuVo skuVo = new SkuVo();
        Integer price = shopInfo.getShopPrice().intValue();
        skuVo.setPrice(price+".00");
        skuVo.setStock_num(shopInfo.getShopStock());
        skuVo.setTree(treeVoList);
        skuVo.setList(shopSpecsCasVoList);

        SpecsPackageVo specsPackageVo = new SpecsPackageVo();
        specsPackageVo.setSku(skuVo);
        Map<String,String> goods = new HashMap<>();
        goods.put("picture", shopInfo.getShopIcon());
        specsPackageVo.setGoods(goods);

        return specsPackageVo;
    }

    /** 减库存的方法 */
    @Override
    public void subStock(Integer specsId, Integer quantity) {

        ShopSpecs shopSpecs = shopSpecsRepository.findById(specsId).get();
        ShopInfo shopInfo = shopInfoRepository.findById(shopSpecs.getShopId()).get();
        Integer result = shopSpecs.getSpecsStock() - quantity;

        if (result < 0) {
            log.error("库存不足耶!");
            throw new ShopException(ResultEnum.SHOP_STOCK_ERROR);
        }

        shopSpecs.setSpecsStock(result);
        shopSpecsRepository.save(shopSpecs);
        result = shopInfo.getShopStock() - quantity;

        if (result < 0) {
            log.error("库存不足耶!");
            throw new ShopException(ResultEnum.SHOP_STOCK_ERROR);
        }

        shopInfo.setShopStock(result);
        shopInfoRepository.save(shopInfo);
    }

}
