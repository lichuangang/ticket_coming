package com.lcgang.ticketComing.common;

import com.lcgang.framework.utils.DateUtil;

public class FileResourcePath {
    public static String BasePath = "localhost:6601";
    public static String BaseUrl = "http://localhost:6601";


    public static String GetTempUrl() {
        return String.format("%s/upload/temp/%s", BaseUrl, DateUtil.getNowFomatString("yyyyMMdd"));
    }

    public static String GetTempUrl(String fileName) {
        return String.format("%s/%s", GetTempUrl(), fileName);
    }
}
