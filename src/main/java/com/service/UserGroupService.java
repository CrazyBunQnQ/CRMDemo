package com.service;

import com.bean.User;
import com.bean.UserGroup;

import java.util.List;

/**
 * @version 2017/7/9.
 * @auther CrazyBunQnQ
 */
public interface UserGroupService extends BaseService<UserGroup> {
    public String getTree();

    List<User> listUserNotByGroupId(Integer id);

    List<User> listUserByGroupId(Integer id);

    Boolean setUser(Integer groupId, String userIds);

    List<UserGroup> listAll();

    List<UserGroup> listGroup();

    boolean clearUserInGroup(Integer id);
}
