package com.lcgang.framework.common;

import com.fcibook.quick.http.QuickHttp;
import com.lcgang.framework.dto.wx.LoginUser;

public class WexinHelper {
    public static LoginUser Get(String code, String appId, String appSecret) {
        String res = new QuickHttp()
                .url("https://api.weixin.qq.com/sns/jscode2session")
                .get()
                .addParame("appid", appId)
                .addParame("secret", appSecret)
                .addParame("js_code", code)
                .addParame("grant_type", "authorization_code")
                .text();
        return JsonHelper.toObject(res, LoginUser.class);
    }
}
