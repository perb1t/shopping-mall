package com.shijiwei.shoppingmall.login.eureka;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        String val = null;
        String val2 = "";
        String val3 = " ";
        String val4 = "1 ";
        System.out.println(StringUtils.isBlank(val) + " | " + StringUtils.isBlank(val2) + " | " + StringUtils.isBlank(val3) + " | " + StringUtils.isBlank(val4));
    }

}
