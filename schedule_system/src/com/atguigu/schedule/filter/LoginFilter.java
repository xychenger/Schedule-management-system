package com.atguigu.schedule.filter;

import com.atguigu.schedule.pojo.SysUser;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: com.atguigu.schedule.filter
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/24 23:56
 * @Version 1.0
 */
//@WebFilter(urlPatterns = {"/showSchedule.html", "/schedule/*"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获得session域对象
        HttpSession session = request.getSession();

        // 从session域中获得登录的用户对象
        SysUser sysUser = (SysUser)session.getAttribute("sysUser");
        // 判断用户对象是否为空 没登录到login.html 登陆过放行
        if (null == sysUser) {
            response.sendRedirect("/login.html");
        }
        else {
            filterChain.doFilter(request, response);
        }
    }
}
