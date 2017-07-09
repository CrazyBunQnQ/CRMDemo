package com.dao;

import com.bean.UserGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    List<UserGroup> findRootProductType();

    List<UserGroup> findSubProductType(@Param("pid") Integer pid);
}