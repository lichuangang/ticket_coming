package com.lcgang.framework.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonHelper {

    private static ObjectMapper objectMapper = new  ObjectMapper();

    public static String toString(Object object)
    {
        String resultStr = null;
        try {
            resultStr = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  resultStr;
    }

    public static <T> T toObject(String json,Class<T> tClass)
    {
        T object = null;
        try {
            object = objectMapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  object;
    }
}
