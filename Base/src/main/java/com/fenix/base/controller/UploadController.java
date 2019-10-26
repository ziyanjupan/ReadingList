package com.fenix.base.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * @Description 上传文件
     * @Author xiaguangyong
     * @Date 2019/10/25 11:49
     * @Param file
     * @Return java.lang.String
     */
    public String file(MultipartFile file) {
        return "success";
    }
}
