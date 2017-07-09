package com.service;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService = null;

    @Test
    public void test() {
        float a = 0.2f;
        float b = 0.4f;

        double a2 = 0.2;
        double b2 = 0.4;

        System.out.println(a + b);
        System.out.println(a2 + b2);
        System.out.println(0.2 + 0.4);
        System.out.println(0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1);
    }
}
