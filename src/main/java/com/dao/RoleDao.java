package com.dao;

import com.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface RoleDao extends BaseDao<Role> {
    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(@Param("ids") Integer[] ids);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

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

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKeyWithBLOBs(Role record);

    int updateByPrimaryKey(Role record);

    int updateRolePopedom(@Param("str") String popedom, @Param("id") Integer role_id);

    String getPopedomByRole(@Param("id") Integer role_id);
}