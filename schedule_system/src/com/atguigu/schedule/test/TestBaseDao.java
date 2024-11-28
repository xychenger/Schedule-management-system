package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.BaseDao;
import com.atguigu.schedule.pojo.SysUser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * ClassName: TestBaseDao
 * Package: com.atguigu.schedule.test
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 20:30
 * @Version 1.0
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        // 查询用户数量
        String sql = "select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }

    @Test
    public void testBaseQuery() {
        // 由于数据库中的user_pwd与实体类中的userPwd的变量名不一致，所以在编写sql语句的时候要通过起别名的方式
        String sql = "select uid, username, user_pwd userPwd from sys_user";
        List<SysUser> sysUserList = baseDao.baseQuery(SysUser.class, sql);
        sysUserList.forEach(System.out::println);
    }

    @Test
    public void testBaseUpdate() {
        String sql = "insert into sys_schedule values(DEFAULT, ?, ?, ?)";
        int rows = baseDao.baseUpdate(sql, 1, "学习java", 0);
        System.out.println(rows);
    }

}
