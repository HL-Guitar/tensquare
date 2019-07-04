package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * ClassName: ManagerFilter
 *
 * @Author: Light
 * @Date: 2019/7/4 20:27
 * Description:
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Override
    public String filterType() {//过滤器类型
        return "pre";//前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;//优先级，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;//过滤器开关，true表示开启
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("后台过滤器");
        return null;
    }
}