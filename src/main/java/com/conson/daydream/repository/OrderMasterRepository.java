package com.conson.daydream.repository;

import com.conson.daydream.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 康森
 * @date 2020/5/2 22 : 54 : 33
 * @description 订单查询接口
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
