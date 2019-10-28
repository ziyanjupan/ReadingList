package com.fenix.base.config;


import com.fenix.base.interceptor.FileHeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BaseConfiguration implements WebMvcConfigurer {
    // WebMvcConfigurerAdapter 已过时（spring5弃用）
    //拦截器，拦截文件流
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new FileHeaderInterceptor())
                .addPathPatterns("/**");
    }
}
