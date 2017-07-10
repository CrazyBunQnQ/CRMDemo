package com.service;

import com.bean.AccessGroupWithBLOBs;
import com.bean.RoleWithBLOBs;
import com.bean.User;
import com.bean.UserGroup;

import java.util.List;

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

    public boolean enableByIds(Integer[] selectedId);

    public boolean disableByIds(Integer[] selectedId);

    public List<RoleWithBLOBs> listRole();

    public List<AccessGroupWithBLOBs> listAccessGroup();

    public List<UserGroup> listGroup();
}
