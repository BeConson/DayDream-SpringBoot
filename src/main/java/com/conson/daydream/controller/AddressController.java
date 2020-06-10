package com.conson.daydream.controller;

import com.conson.daydream.entity.UserAddress;
import com.conson.daydream.exception.ShopException;
import com.conson.daydream.form.AddressForm;
import com.conson.daydream.service.AddressService;
import com.conson.daydream.util.ResultVoUtil;
import com.conson.daydream.vo.ResultVo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 康森
 * @date 2020/5/5 22 : 00 : 09
 * @description 地址请求
 */
@CrossOrigin
@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVo list(){
        return ResultVoUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVo create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[ 新增地址 ] ：参数错误 , addressForm = {}", addressForm);
            throw new ShopException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ResultVoUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVo update(@Valid @RequestBody AddressForm addressForm,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[ 修改地址 ] ：参数错误 , addressForm={}", addressForm);
            throw new ShopException(bindingResult.getFieldError().getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ResultVoUtil.success(null);
    }

    @GetMapping("/delete/{id}")
    public void deleteAddress(@PathVariable("id") Integer id){
         addressService.deleteAddress(id);
    }

}
