package com.conson.daydream.service.impl;

import com.conson.daydream.form.AddressForm;
import com.conson.daydream.service.AddressService;
import com.conson.daydream.vo.AddressVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    void findAll(){
        List<AddressVo> list = addressService.findAll();
        int id = 0;
    }

    @Test
    void saveOrUpdate(){
        AddressForm addressForm = new AddressForm();
        addressForm.setId(37);
        addressForm.setName("2333");
        addressForm.setTel("111");
        addressForm.setProvince("北京市");
        addressForm.setCity("北京市");
        addressForm.setCounty("东城区");
        addressForm.setAreaCode("110101");
        addressForm.setAddressDetail("168号606室");
        addressService.saveOrUpdate(addressForm);
    }


    @Test
    void deleteAddress() {
        addressService.deleteAddress(2);
    }
}