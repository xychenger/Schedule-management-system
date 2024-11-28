package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

/**
 * Data access Object 数据访问对象
 * 该类中用于定义针对表格CRUD的方法
 * DAO层一般需要定义接口和实现类
 */
public interface SysUserDao {
    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要注册的用户名和明文密码 以SysUser的形式接受
     * @return 返回受影响的行数
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 返回查询到的用户对象
     */
    SysUser findByUsername(String username);
}
