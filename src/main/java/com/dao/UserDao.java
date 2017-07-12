package com.dao;

import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface UserDao extends BaseDao<User> {
    /**
     * According to the user name password query users
     *
     * @param name
     * @param password
     *
     * @return
     */
    User findUser(@Param("name") String name, @Param("password") String password);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    @Override
    int insertSelective(User record);

    @Override
    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    @Override
    int updateByPrimaryKey(User record);

    int enableOrDisableByIds(@Param("ids") Integer[] ids, @Param("enable") Boolean enable);

    List<User> listUserByGroup(@Param("id") Integer id, @Param("byId") boolean byId);

    int updateUsersGroup(@Param("groupId") Integer groupId, @Param("ids") Integer[] ids);

    int countUsersByAccessGroupId(@Param("agid") Integer accessGroupId);

    int clearUserInGroup(@Param("id") Integer id);
}