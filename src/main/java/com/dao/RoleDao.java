package com.dao;

import com.bean.Role;
import com.bean.RoleWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(@Param("ids") Integer[] ids);

    int insert(RoleWithBLOBs record);

    int insertSelective(RoleWithBLOBs record);

    RoleWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * Paging query role
     *
     * @param from
     * @param pageSize
     *
     * @return
     */
    List<Role> selectRoleByPage(@Param("name") String name, @Param("from") int from, @Param("pageSize") int pageSize);

    /**
     * Query total number of roles
     *
     * @return
     */
    int countRole(@Param("name") String name);

    int updateByPrimaryKeySelective(RoleWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RoleWithBLOBs record);

    int updateByPrimaryKey(Role record);
}