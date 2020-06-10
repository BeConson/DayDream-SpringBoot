package com.conson.daydream.service.impl;

import com.conson.daydream.dto.OrderDTO;
import com.conson.daydream.entity.OrderMaster;
import com.conson.daydream.entity.ShopInfo;
import com.conson.daydream.entity.ShopSpecs;
import com.conson.daydream.enums.PayStatusEnum;
import com.conson.daydream.enums.ResultEnum;
import com.conson.daydream.exception.ShopException;
import com.conson.daydream.repository.OrderMasterRepository;
import com.conson.daydream.repository.ShopInfoRepository;
import com.conson.daydream.repository.ShopSpecsRepository;
import com.conson.daydream.service.OrderService;
import com.conson.daydream.service.ShopService;
import com.conson.daydream.util.KeyUtil;
import com.conson.daydream.vo.OrderDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 康森
 * @date 2020/5/4 21 : 26 : 43
 * @description 用户订单业务实现
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ShopSpecsRepository shopSpecsRepository;

    @Autowired
    private ShopInfoRepository shopInfoRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ShopService shopService;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();

        //赋值
        BeanUtils.copyProperties(orderDTO,orderMaster);

        ShopSpecs shopSpecs = shopSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if (shopSpecs == null){
            log.error("查询订单: 订单不存在哦 , shopSpecs={}", shopSpecs);
            throw new ShopException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(shopSpecs,orderMaster);

        ShopInfo shopInfo = shopInfoRepository.findById(shopSpecs.getShopId()).get();
        if (shopInfo == null){
            log.error("查询订单: 商品不存在哦 , shopInfo={}", shopInfo);
            throw new ShopException(ResultEnum.SHOP_NOT_EXIST);
        }
        BeanUtils.copyProperties(shopInfo,orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = shopSpecs.getSpecsPrice()
                .divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getShopQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(520));
        orderMaster.setOrderAmount(orderAmount);

        //订单ID
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        //支付状态码
        orderMaster.setPayStatus(PayStatusEnum.UN_PAY.getCode());
        orderMasterRepository.save(orderMaster);

        //支付后减库存
        shopService.subStock(orderDTO.getSpecsId(),orderDTO.getShopQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVo findOrderDetailByOrderId(String orderId) {
        OrderDetailVo orderDetailVo = new OrderDetailVo();

        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

            if (orderMaster == null){
                log.error("查询订单: 订单不存在哦 , orderMaster={}", orderMaster);
                throw new ShopException(ResultEnum.ORDER_NOT_EXIST);
            }

        BeanUtils.copyProperties(orderMaster, orderDetailVo);
        orderDetailVo.setSpecsPrice(orderMaster.getSpecsPrice()
                .divide(new BigDecimal(100)) + ".00");

        return orderDetailVo;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if (orderMaster == null){
            log.error("支付信息: 订单不存在哦 , orderMaster={}", orderMaster);
            throw new ShopException(ResultEnum.ORDER_NOT_EXIST);
        }

        if (orderMaster.getPayStatus().equals(PayStatusEnum.UN_PAY.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAY.getCode());
            orderMasterRepository.save(orderMaster);
        }else {
            log.error("支付信息: 订单已支付 , orderMaster={}", orderMaster);
            throw new ShopException(ResultEnum.ORDER_PAY);
        }

        return orderId;
    }

    @Override
    public List<OrderMaster> findAllOrder() {
        List<OrderMaster> order = orderMasterRepository.findAll();
        return order;
    }

    @Override
    public void deleteOrder(String id) {
        orderMasterRepository.deleteById(id);
    }

}
