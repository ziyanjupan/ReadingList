package com.fenix.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
     * @Description 单上传文件
     * @Author xiaguangyong
     * @Date 2019/10/25 11:49
     * @Param file
     * @Return java.lang.String
     */
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public String file(MultipartFile file) {
        if (file.isEmpty()) {
            return "请选择文件";
        }
        String fileName = file.getOriginalFilename();
        if (!checkFileTypeIsEnable(fileName)){
            return "文件格式不支持";
        }
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


    /**
     * 多文件上传
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/multiFiles", method = RequestMethod.POST)
    public String multiFiles(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "C:/upload/";
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                return "上传第" + (i++) + "个文件失败";
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                logger.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                logger.error(e.toString(), e);
                return "上传第" + (i++) + "个文件失败";
            }
        }
        return "上传成功";
    }

    /**
     * 检查文件类型是否符合要求
     *
     * @param fileName
     * @return
     */
    private Boolean checkFileTypeIsEnable(String fileName) {
        //设置允许上传文件类型
        String enableSuffixList = "jpg,gif,png,ico,bmp,jpeg";
        // 获取文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf(".")
                + 1);

        if (enableSuffixList.contains(suffix.trim().toLowerCase())) {
            return true;
        }
        return false;
    }
}
