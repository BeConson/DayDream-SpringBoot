package com.conson.daydream.service.impl;

import com.conson.daydream.entity.UserAddress;
import com.conson.daydream.form.AddressForm;
import com.conson.daydream.repository.UserAddressRepository;
import com.conson.daydream.service.AddressService;
import com.conson.daydream.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 康森
 * @date 2020/5/4 19 : 27 : 14
 * @description 地址业务实现
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public List<AddressVo> findAll() {
        List<AddressVo> list = userAddressRepository.findAll().stream()
                .map( e-> new AddressVo(
                        e.getAddressId(),
                        e.getAreaCode(),
                        e.getUserName(),
                        e.getUserPhone(),
                        e.getUserAddress()
                )).collect(Collectors.toList());
        return list;
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        UserAddress userAddress;
        if (addressForm.getId() == null) {
            userAddress = new UserAddress();
        }else {
            userAddress = userAddressRepository.findById(addressForm.getId()).get();
        }
        userAddress.setUserName(addressForm.getName());
        userAddress.setUserPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        userAddress.setUserAddress(stringBuffer.toString());
        userAddress.setAreaCode(addressForm.getAreaCode());

        userAddressRepository.save(userAddress);
    }

    @Override
    public void deleteAddress(Integer id) {
         userAddressRepository.deleteById(id);
    }
}
