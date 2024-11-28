package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;
import com.atguigu.schedule.service.impl.SysScheduleServiceImpl;
import com.atguigu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 增加日程的请求 /schedule/add
 * 查询日程的请求 /schedule/find
 * 修改日程的请求 /schedule/update
 * 删除日程的请求 /schedule/remove
 * ... ...
 */
@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService sysScheduleService = new SysScheduleServiceImpl();

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));

        // 调用服务层方法删除数据
        sysScheduleService.removeSchedule(sid);

        WebUtil.writeJson(resp, Result.ok(null));

    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求体中的json串，转换成一个SysSchedule
        SysSchedule schedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务层方法将数据更新进入数据库
        sysScheduleService.updateSchedule(schedule);

        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        // 调用服务层方法，向数据库中增加一条空记录
        sysScheduleService.addDefalut(uid);

        WebUtil.writeJson(resp, Result.ok(null));
    }

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));

        // 查询用户的所有日程
        List<SysSchedule> itemList = sysScheduleService.findItemListByUid(uid);
        // 将用户的所有日程放入一个Result对象
        Map data = new HashMap();
        data.put("itemList", itemList);

        Result result = Result.ok(data);
        // 将Result对象转换为json响应给客户端
        WebUtil.writeJson(resp, result);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("add");
    }

    protected void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("find");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("update");
    }

    protected void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("remove");
    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        // 判断此次请求
//        String requestURI = req.getRequestURI(); // /schedule/add
//        String[] split = requestURI.split("/");
//        String methodName = split[split.length - 1];
//
//        // 使用 反射 通过方法名获取下面的方法
//        Class aClass = this.getClass();
//        // 获取方法
//        try {
//            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//            // 暴力破解方法的访问修饰符的限制
//            // 设置方法可以访问
//            declaredMethod.setAccessible(true);
//            // 执行方法
//            declaredMethod.invoke(this, req, resp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//         //通过以上方式，未来想要定义方法，只需要在下面增加方法，无需改动上面的代码
//
//        if ("add".equals(methodName)) {
//            // 增加日程的处理
//            add(req, resp);
//        }
//        else if ("find".equals(methodName)) {
//            // 查询日程的处理
//            find(req, resp);
//        }
//        else if ("update".equals(methodName)) {
//            // 更新日程的处理
//            update(req, resp);
//        }
//        else if ("remove".equals(methodName)) {
//            // 删除日程的处理
//            remove(req, resp);
//        }

//    }

}
