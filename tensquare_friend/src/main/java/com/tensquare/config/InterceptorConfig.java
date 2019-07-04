package com.tensquare.config;

import com.tensquare.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * ClassName: InterceptorConfig
 *
 * @Author: Light
 * @Date: 2019/6/6 23:20
 * Description:
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    //主要是代码springmvc配置文件使拦截器生效

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器,要声明要拦截的对象和要拦截的请求
        registry.addInterceptor(jwtInterceptor).
                addPathPatterns("/**")  //拦截所有
                .excludePathPatterns("/**/login/**");  //放行登录页面
    }
}