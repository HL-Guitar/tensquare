package com.tensquare.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ManagerFilter
 *
 * @Author: Light
 * @Date: 2019/7/4 20:27
 * Description:
 */
@Component
public class WebFilter extends ZuulFilter {

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

        //向heander中添加鉴权令牌
        //获取当前容器对象
        RequestContext requestcontext = RequestContext.getCurrentContext();
        //获取request对象,和header
        HttpServletRequest request = requestcontext.getRequest();
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        if (authorization!=null) {
            requestcontext.addZuulRequestHeader("Authorization",authorization);
        }
        //放行
        return null;
    }
}