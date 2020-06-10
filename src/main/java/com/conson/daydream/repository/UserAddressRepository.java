package com.conson.daydream.repository;

import com.conson.daydream.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 康森
 * @date 2020/5/2 22 : 14 : 41
 * @description 用户地址查询接口
 */
public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {
}
