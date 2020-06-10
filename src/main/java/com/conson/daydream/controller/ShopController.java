package com.conson.daydream.controller;

import com.conson.daydream.service.ShopService;
import com.conson.daydream.util.ResultVoUtil;
import com.conson.daydream.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 康森
 * @date 2020/5/5 21 : 31 : 44
 * @description 商品查询请求
 */
@CrossOrigin
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/index")
    public ResultVo index(){
        return ResultVoUtil.success(shopService.findDataVo());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVo findByCategoryType(
            @PathVariable("categoryType") Integer categoryType){
        return ResultVoUtil.success(shopService.findShopInfoVoByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByShopId/{shopId}")
    public ResultVo findSpecsByPhoneId(
            @PathVariable("shopId") Integer shopId){
        return ResultVoUtil.success(shopService.findSpecsPackageVoByShopId(shopId));
    }
}
