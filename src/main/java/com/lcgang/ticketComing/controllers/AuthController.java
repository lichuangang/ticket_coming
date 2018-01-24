package com.lcgang.ticketComing.controllers;

import com.lcgang.framework.common.WexinHelper;
import com.lcgang.framework.dto.ApiResult;
import com.lcgang.framework.dto.wx.LoginUser;
import com.lcgang.framework.utils.ApiResultFactory;
import com.lcgang.ticketComing.dtos.auth.SetLocationParam;
import com.lcgang.ticketComing.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Value("${wx.appId}")
    String appId;

    @Value("${wx.appSecret}")
    String appSecret;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getLoginUser", method = RequestMethod.GET)
    public ApiResult getLoginUser(String code) {
        LoginUser u = WexinHelper.Get(code, appId, appSecret);

        //如果用户之前保存过坐标，返回坐标
        if (u.getErrcode() == 0) {
            u.setCoordinate(userService.getCoordinate(u.getOpenid()));
        }

        return ApiResultFactory.Create(u);
    }

    @RequestMapping(value = "/setLocation", method = RequestMethod.POST)
    public ApiResult setLocation(@RequestBody SetLocationParam param) {

        userService.setUserLocation(param);
        return ApiResultFactory.Create();
    }

}
