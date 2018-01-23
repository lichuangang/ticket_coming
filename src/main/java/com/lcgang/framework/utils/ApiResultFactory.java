package com.lcgang.framework.utils;

import com.lcgang.framework.dto.ApiResult;

public class ApiResultFactory {
    public static ApiResult Create() {
        return new ApiResult();
    }

    public static <T> ApiResult Create(T data) {
        ApiResult result = new ApiResult<T>();
        result.setData(data);
        return result;
    }

    public static ApiResult Create(int code, String msg) {
        ApiResult result = new ApiResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
