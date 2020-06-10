package com.conson.daydream.util;

import java.util.Random;

/**
 * @author 康森
 * @date 2020/5/4 21 : 40 : 55
 * @description 用于生成订单编号
 */
public class KeyUtil {
    public static synchronized String createUniqueKey(){
        Random random = new Random();
        Integer key =  random.nextInt(900000)+100000;
        //返回一个系统毫秒数加上随机生成的六位数字
        return System.currentTimeMillis() + String.valueOf(key);
    }
}
