package com.fenix.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @Author: xiaguangyong
 * @ClassName: FileUploadController
 * @Description: 文件上传控制器
 * @Date: 2019/10/25 10:36
 * @Version: 1.0
 * @Modify:
 */
@RestController(value = "/upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    /**
     * @Description 上传文件
     * @Author xiaguangyong
     * @Date 2019/10/25 11:49
     * @Param file
     * @Return java.lang.String
     */
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public String file(MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = "C:/upload/";
        File dest = new File(filePath, fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            return "success";
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return "failed";
        }
    }
}
