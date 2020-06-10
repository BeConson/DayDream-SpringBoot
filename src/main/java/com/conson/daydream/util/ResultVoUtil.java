package com.conson.daydream.util;

import com.conson.daydream.vo.ResultVo;

/**
 * @author 康森
 * @date 2020/5/5 21 : 45 : 31
 * @description
 */
public class ResultVoUtil {
    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo error(String error){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg(error);
        resultVo.setData(null);
        return resultVo;
    }
}
