package com.lcgang.ticketComing.common;

import com.lcgang.framework.dto.ApiResult;
import com.lcgang.framework.utils.ApiResultFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    private static Logger logger = LogManager.getLogger(ExceptionControllerAdvice.class.getName());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ApiResult errorHandler(Exception ex) {
        logger.error(ex);
        return ApiResultFactory.Create(500, ex.getMessage());
    }

}
