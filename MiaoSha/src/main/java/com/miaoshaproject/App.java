package com.miaoshaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class App {

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }

    public static void main(String[] args) {
        System.out.println("hello world");

        SpringApplication.run(App.class, args);
    }
}
