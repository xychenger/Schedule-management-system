package com.atguigu.schedule.test;

import com.atguigu.schedule.util.MD5Util;
import org.testng.annotations.Test;

/**
 * ClassName: TestMD5Util
 * Package: com.atguigu.schedule.test
 * Description:
 *
 * @Author 夏叶城二
 * @Create 2024/11/21 23:04
 * @Version 1.0
 */
public class TestMD5Util {
    @Test
    public void testEncrypt() {
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }

}
