package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysUserDao;
import com.atguigu.schedule.dao.impl.SysUserDaoImpl;
import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.util.MD5Util;

/**
 * ClassName: SysUserServiceImpl
 * Package: com.atguigu.schedule.service.impl
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 22:08
 * @Version 1.0
 */
public class SysUserServiceImpl implements SysUserService {

    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        // 将用户的明文密码转化为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));

        // 调用Dao层方法将sysUser信息存入数据库中
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
