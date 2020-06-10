package com.conson.daydream.service;

import com.conson.daydream.form.AddressForm;
import com.conson.daydream.vo.AddressVo;

import java.util.List;

/**
 * @author 康森
 * @date 2020/5/4 19 : 21 : 39
 * @description 用户地址业务
 */
public interface AddressService {
    public List<AddressVo> findAll();
    public void saveOrUpdate(AddressForm addressForm);
    public void deleteAddress(Integer id);
}
