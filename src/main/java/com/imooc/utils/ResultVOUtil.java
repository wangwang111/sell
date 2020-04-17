package com.imooc.utils;

import com.imooc.VO.ResultVO;

/**
 * Created by 廖师兄
 * 2017-05-15 00:22
 */
public class ResultVOUtil<T> {

    public static <T> ResultVO<T> success(T object) {
        ResultVO<T> resultVO = new ResultVO<T>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
