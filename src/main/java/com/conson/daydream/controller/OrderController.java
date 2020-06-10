package com.conson.daydream.controller;

import com.conson.daydream.dto.OrderDTO;
import com.conson.daydream.exception.ShopException;
import com.conson.daydream.form.OrderForm;
import com.conson.daydream.service.OrderService;
import com.conson.daydream.util.ResultVoUtil;
import com.conson.daydream.vo.ResultVo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 康森
 * @date 2020/5/5 22 : 43 : 59
 * @description 订单请求
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResultVo create(@Valid @RequestBody OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("[ 新增地址 ] ：参数错误,orderForm= {}", orderForm);
            throw new ShopException(bindingResult.getFieldError().getDefaultMessage());
        }
        //将orderForm 转换成 orderDTO
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserName(orderForm.getName());
        orderDTO.setUserPhone(orderForm.getTel());
        orderDTO.setUserAddress(orderForm.getAddress());
        orderDTO.setSpecsId(orderForm.getSpecsId());
        orderDTO.setShopQuantity(orderForm.getQuantity());

        OrderDTO result = orderService.createOrder(orderDTO);

        Map<String,String> map = new HashMap<>();
        map.put("orderId",result.getOrderId());

        return ResultVoUtil.success(map);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVo findOrderDetail(@PathVariable("orderId") String orderId){
        return ResultVoUtil.success(orderService.findOrderDetailByOrderId(orderId));
    }

    @PutMapping("/pay/{orderId}")
    public ResultVo pay(@PathVariable("orderId") String orderId){
        Map<String,String> map = new HashMap<>();
        map.put("orderId",orderService.pay(orderId));
        return ResultVoUtil.success(map);
    }

    @GetMapping("/myOrder")
    public ResultVo findAllOrder(){
        return ResultVoUtil.success(orderService.findAllOrder());
    }

    @GetMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") String id){
        orderService.deleteOrder(id);
    }

}
