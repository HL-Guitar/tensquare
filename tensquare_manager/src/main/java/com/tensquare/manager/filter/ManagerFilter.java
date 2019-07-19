package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ManagerFilter
 *
 * @Author: Light
 * @Date: 2019/7/4 20:27
 * Description:
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private  JwtUtil jwtUtil;
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
        //向heander中添加鉴权令牌
        //获取当前容器对象
        RequestContext requestcontext = RequestContext.getCurrentContext();
        //获取request对象,和header
        HttpServletRequest request = requestcontext.getRequest();
        if (request.getMethod().equals("OPTIONS")){
            return null;
        }
        if (request.getRequestURI().indexOf("login")>0){
            return null;
        }
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        if (authorization!=null && !"".equals(authorization)) {
            if (authorization.startsWith("Bearer ")) {
                try {
                    String token = authorization.substring(7);
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")) {
                        requestcontext.addZuulRequestHeader("Authorization", authorization);
                        return null;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    requestcontext.setSendZuulResponse(false);//终止运行
                }

            }
        }
        requestcontext.setSendZuulResponse(false);//终止运行
        requestcontext.setResponseStatusCode(403);
        requestcontext.setResponseBody("权限不足");
        requestcontext.getResponse().setContentType("text/html;charset=utf-8");
        return null;//
    }
}