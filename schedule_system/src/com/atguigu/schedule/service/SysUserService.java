package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysUser;

/**
 * 该接口定义了以sys_user为核心的业务处理功能
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser 要注册的用户名和明文密码 以SysUser的形式接受
     * @return 返回影响的行数
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 返回查询到的用户对象
     */
    SysUser findByUsername(String username);
}
