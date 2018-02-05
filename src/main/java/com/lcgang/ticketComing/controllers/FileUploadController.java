package com.lcgang.ticketComing.controllers;

import com.lcgang.framework.dto.ApiResult;
import com.lcgang.framework.dto.file.FileResult;
import com.lcgang.framework.utils.ApiResultFactory;
import com.lcgang.framework.utils.DateUtil;
import com.lcgang.framework.utils.FileUtil;
import com.lcgang.framework.utils.UUIDUtil;
import com.lcgang.ticketComing.common.FileResourcePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


@RestController
public class FileUploadController {

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public ApiResult fileUpload(@RequestParam("file") MultipartFile file,
                                HttpServletRequest request) {
        String filePath = request.getSession().getServletContext().getRealPath("upload/temp/" + DateUtil.getNowFomatString("yyyyMMdd"));
        String orgFileName = file.getOriginalFilename();
        //新文件名
        String fileName = UUIDUtil.newUUID() + FileUtil.suffixName(orgFileName);

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return ApiResultFactory.Create(500, "文件上传失败，请稍后重试.");
        }

        FileResult result = new FileResult();
        result.setFileName(fileName);
        result.setOrgName(orgFileName);
        result.setUrl(FileResourcePath.GetTempUrl(fileName));

        return ApiResultFactory.Create(result);
    }
}
