package com.service;

import com.alibaba.fastjson.JSON;
import com.bean.User;
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
        User user = userService.getUserById(1);

        log.info(JSON.toJSONString(user));
    }
}
