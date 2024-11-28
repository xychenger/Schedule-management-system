package com.atguigu.schedule.pojo;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * 1 实体类的类名应该与表格名称对应 （对应不是一致）
 * 2 实体类的属性名和表格的列名应该对应 （下划线做驼峰转换）
 * 3 每个属性都必须是私有的
 * 4 每个属性都应该具备 getter 和 setter 方法
 * 5 必须具备无参构造器
 * 6 应该实现序列化接口 （缓存 分布式项目数据传递 可能会将对象序列化）
 * 7 应该重写类的hashcode 和 equals 方法
 * 8 toString重不重写都可以
 *
 * 使用lombok帮助我们生成这些内容
 *  lombok使用步骤
 *      1 检查IDEA是否已经安装了lombok插件
 *      2 检查是否勾选了 enable annotation processing
 *      3 导入lombok的依赖
 */


@AllArgsConstructor // 添加了全参构造
@NoArgsConstructor // 添加了无参构造
@Data // getter setter toString equals hashcode
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;

//    public SysUser(Integer uid, String username, String userPwd) {
//        this.uid = uid;
//        this.username = username;
//        this.userPwd = userPwd;
//    }
//
//    public SysUser() {
//    }
//
//    public Integer getUid() {
//        return uid;
//    }
//
//    public void setUid(Integer uid) {
//        this.uid = uid;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUserPwd() {
//        return userPwd;
//    }
//
//    public void setUserPwd(String userPwd) {
//        this.userPwd = userPwd;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SysUser sysUser = (SysUser) o;
//        return Objects.equals(uid, sysUser.uid) && Objects.equals(username, sysUser.username) && Objects.equals(userPwd, sysUser.userPwd);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(uid, username, userPwd);
//    }
//
//    @Override
//    public String toString() {
//        return "SysUser{" +
//                "uid=" + uid +
//                ", username='" + username + '\'' +
//                ", userPwd='" + userPwd + '\'' +
//                '}';
//    }
}
