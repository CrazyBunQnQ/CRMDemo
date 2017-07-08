package com.service;

import com.bean.User;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface UserService extends BaseService<User> {
    /**
     * According to the user name password query users
     *
     * @param name
     * @param password
     *
     * @return
     */
    public User findUser(String name, String password);

    public User getUserById(int userId);
}
