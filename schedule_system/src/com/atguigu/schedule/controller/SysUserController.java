package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.common.ResultCodeEnum;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.MD5Util;
import com.atguigu.schedule.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * */
@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();

    /**
     * 注册时，接受要注册的用户名，校验用户名是否被占用的业务接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUsernameUsed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受用户名
        String username = req.getParameter("username");
        // 调用服务层业务处理方法查询该用户名是否有对应的用户
        SysUser sysUser = userService.findByUsername(username);

        Result result = Result.ok(null);

        // 如果有 响应 已占用
        if (null != sysUser) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        // 如果没有 响应可用
        // 将result对象转换为json串响应给客户端
        // ObjectMapper
        WebUtil.writeJson(resp, result);

    }

    /**
     * 接受用户登录请求，完成登录业务的接口
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);

        // 接受用户名和密码
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");

        // 调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(sysUser.getUsername());
        Result result = null;

        if (null == loginUser) {
            // 跳转到用户名有误提示页
//            resp.sendRedirect("/loginUsernameError.html");
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        else if (! MD5Util.encrypt(sysUser.getUserPwd()).equals(loginUser.getUserPwd())) {
            // 跳转到密码有误提示页
//            resp.sendRedirect("/loginUserPwdError.html");
            result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
        }
        else {
            // 登录成功之后将登录的用户信息放入session域
//            HttpSession session = req.getSession();
//            session.setAttribute("sysUser", loginUser);
//
//            // 跳转到首页
//            resp.sendRedirect("/showSchedule.html");

            // 登录成功，将用户的uid和username响应给客户端

            Map data = new HashMap();
            loginUser.setUserPwd("");
            data.put("loginUser", loginUser);



            result = Result.ok(data);
        }
        // 将登陆结果响应给客户端
        WebUtil.writeJson(resp, result);
    }

    /**
     * 接受用户注册请求的业务处理方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收客户端提交的json参数，并转换为User对象，获取信息
        SysUser registUser = WebUtil.readJson(req, SysUser.class);


        // 1 接受客户端提交的参数
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");

        // 2 调用服务层方法，完成注册功能
            // 将参数放入一个SysUser对象中，在调用regist方法时传入
//            SysUser sysUser = new SysUser(null, username, userPwd);

        int rows = userService.regist(registUser);
        // 3 根据注册结果 （成功 失败） 做页面跳转
//        if (rows > 0) {
//            // 使用响应重定向 并且写成绝对路径，当前项目的上下文已经设置成/
//            resp.sendRedirect("/registSuccess.html");
//        }
//        else {
//            resp.sendRedirect("/registFail.html");
//        }
        Result result = Result.ok(null);
        if (rows < 1) {
            result = Result.build(null, ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp, result);
    }
}
