package com.conson.daydream.repository;

import com.conson.daydream.entity.UserAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class UserAddressRepositoryTest {

    @Autowired
    private UserAddressRepository addressRepository;

    @Test
    void findAll(){
        List<UserAddress> list  = addressRepository.findAll();
        for (UserAddress userAddress : list) {
            System.out.println(userAddress);
        }
    }

    @Test
    void save(){
        UserAddress userAddress = new UserAddress();
        userAddress.setUserName("coco son");
        userAddress.setAreaCode("11111");
        userAddress.setAddressId(4);
        userAddress.setUserPhone("666");
        userAddress.setUserAddress("土星");
        addressRepository.save(userAddress);
    }

    @Test
    void update(){
        UserAddress userAddress = addressRepository.findById(35).get();
        userAddress.setUserName("zhu po po");
        addressRepository.save(userAddress);
    }
}