package com.lcgang.framework.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getNowFomatString(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }
}
