package com.atguigu.schedule.test;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * ClassName: TestSysScheduleDao
 * Package: com.atguigu.schedule.test
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 21:17
 * @Version 1.0
 */
public class TestSysScheduleDao {

    private static SysScheduleDao sysScheduleDao;
    @BeforeClass
    public static void initScheduleDao() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }
    @Test
    public void testAddSchedule() {
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null, 2, "学习数据库", 1));
        System.out.println(rows);
    }
    @Test
    public void testfindAll() {
        List<SysSchedule> all = sysScheduleDao.findAll();
        all.forEach(System.out::println);
    }
}
