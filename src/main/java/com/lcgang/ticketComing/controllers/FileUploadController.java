package com.lcgang.ticketComing.controllers;

import com.lcgang.framework.utils.DateUtil;
import com.lcgang.framework.utils.FileUtil;
import com.lcgang.framework.utils.UUIDUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FileUploadController {

    @RequestMapping(value="/fileUpload", method = RequestMethod.POST)
    public void fileUpload(@RequestParam("file") MultipartFile file,
                           HttpServletRequest request){
        String filePath = request.getSession().getServletContext().getRealPath("upload/temp/"+ DateUtil.getNowFomatString("yyyyMMdd"));
        String orgFileName = file.getOriginalFilename();
        //新文件名
        String fileName= UUIDUtil.newUUID() + FileUtil.suffixName(orgFileName);


    }
}
