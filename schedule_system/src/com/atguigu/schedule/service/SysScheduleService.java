package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleService
 * Package: com.atguigu.schedule.service
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 22:10
 * @Version 1.0
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefalut(int uid);

    Integer updateSchedule(SysSchedule schedule);

    Integer removeSchedule(int sid);
}
