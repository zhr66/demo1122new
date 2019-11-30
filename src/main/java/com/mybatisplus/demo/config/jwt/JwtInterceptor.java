package com.mybatisplus.demo.config.jwt;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//拦截器
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //自动排除生成token的路径,并且如果是options请求是cors跨域预请求，设置allow对应头信息
        if(request.getRequestURI().equals("/sign-in")|| RequestMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("自动排除生成token的路径");
            return true ;
        }


        String token = request.getHeader("Authorization");
        if (token == null || token.trim()=="") {
            throw new ServletException("无法获取token.");
        }
        //获取表中的token
        System.out.println("获取到的token=="+token);
        try {
            JwtUtils.checkToken(token);
            return true;
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}

