package com.tensquare.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: JwtInterceptor
 *
 * @Author: Light
 * @Date: 2019/6/6 23:15
 * Description:
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //拦截器只是把请求头中的token进行一个验证，具体能不能操作要到后面的操作中判断
        //获取头信息
        final String authorization = request.getHeader("Authorization");
        if (authorization!=null && authorization.startsWith("Bearer ")) {
            try {
                //获取token
                final String token = authorization.substring(7);
                //token解析
                Claims claims = jwtUtil.parseJWT(token);
                if (claims!=null) {
                    //分别将对应的角色存入域对象
                    if ("admin".equals(claims.get("roles"))) {
                        //如果是管理员
                        request.setAttribute("admin_claims",claims);
                    }
                    if ("user".equals(claims.get("roles"))) {
                        //如果是用户
                        request.setAttribute("user_claims",claims);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("令牌不正确！");
            }
        }
        return true;
    }
}