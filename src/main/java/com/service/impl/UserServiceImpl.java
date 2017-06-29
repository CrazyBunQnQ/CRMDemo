package com.service.impl;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(3);
    }
}
