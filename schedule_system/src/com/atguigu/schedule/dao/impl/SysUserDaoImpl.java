package com.atguigu.schedule.dao.impl;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.pojo.SysUser;

import java.util.List;

/**
 * ClassName: SysUserDaoImpl
 * Package: com.atguigu.schedule.dao.impl
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 20:09
 * @Version 1.0
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {

    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT, ?, ?)";
        return baseUpdate(sql, sysUser.getUsername(), sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql = "select uid, username, user_pwd userPwd from sys_user where username = ?;";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList != null && sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }
}
