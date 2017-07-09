package com.dao;

import com.bean.UserGroup;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface UserGroupDao extends BaseDao<UserGroup> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserGroup record);

    @Override
    int insertSelective(UserGroup record);

    @Override
    UserGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserGroup record);

    int updateByPrimaryKeyWithBLOBs(UserGroup record);

    @Override
    int updateByPrimaryKey(UserGroup record);
}