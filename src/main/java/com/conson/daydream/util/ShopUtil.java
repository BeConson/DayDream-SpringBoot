package com.conson.daydream.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 康森
 * @date 2020/5/3 22 : 28 : 39
 * @description 分割字符
 */
public class ShopUtil {
    public static List<Map<String, String>> createTag(String tag) {

        String[] tags = tag.split("&");
        List<Map<String, String>> list = new ArrayList<>();
        Map<String,String> map;
        for (String s : tags) {
            map = new HashMap<>();
            map.put("name",s);
            list.add(map);
        }
        return list;
    }
}
