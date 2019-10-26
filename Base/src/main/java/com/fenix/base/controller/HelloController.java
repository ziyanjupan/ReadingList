package com.fenix.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xiaguangyong
 * @ClassName: HelloController
 * @Description: 测试Controller
 * @Date: 2019/10/25 11:54
 * @Version: 1.0
 * @Modify:
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
