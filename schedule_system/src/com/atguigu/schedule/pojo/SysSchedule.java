package com.atguigu.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: SysSchedule
 * Package: com.atguigu.schedule.pojo
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 19:57
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;
}
