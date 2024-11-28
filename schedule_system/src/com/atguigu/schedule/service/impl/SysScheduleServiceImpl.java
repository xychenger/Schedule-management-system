package com.atguigu.schedule.service.impl;

import com.atguigu.schedule.dao.SysScheduleDao;
import com.atguigu.schedule.dao.impl.SysScheduleDaoImpl;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;

import java.util.List;

/**
 * ClassName: SysScheduleService
 * Package: com.atguigu.schedule.service.impl
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 22:10
 * @Version 1.0
 */
public class SysScheduleServiceImpl implements SysScheduleService {
    private SysScheduleDao scheduleDao = new SysScheduleDaoImpl();
    @Override
    public List<SysSchedule> findItemListByUid(int uid) {
        return scheduleDao.findItemListByUid(uid);
    }

    @Override
    public Integer addDefalut(int uid) {
        return scheduleDao.addDefault(uid);
    }

    @Override
    public Integer updateSchedule(SysSchedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    @Override
    public Integer removeSchedule(int sid) {
        return scheduleDao.removeSchedule(sid);
    }
}
