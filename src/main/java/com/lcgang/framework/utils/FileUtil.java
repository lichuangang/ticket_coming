package com.lcgang.framework.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        Path fullPath = Paths.get(filePath, fileName);
        FileOutputStream out = new FileOutputStream(fullPath.toString());
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 返回后缀名 包括.号
     */
    public static String suffixName(String fileName) {
       return suffixName(fileName,true);
    }

    /***
     * 返回后缀名 是否包括.号
     */
    public static String suffixName(String fileName, boolean incSpot) {
        if (incSpot) {
            return fileName.substring(fileName.lastIndexOf("."));
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
    }
}
