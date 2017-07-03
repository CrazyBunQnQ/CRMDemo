package com.dao;

import com.bean.Popedom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface PopedomDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Popedom record);

    int insertSelective(Popedom record);

    Popedom selectByPrimaryKey(Integer id);

    /**
     * 获取根节点的权限列表
     *
     * @return
     */
    List<Popedom> listRootPopedom();

    /**
     * 获取某个父节点下的权限列表
     *
     * @param pid
     *
     * @return
     */
    List<Popedom> listSubPopedom(@Param("pid") Integer pid);

    int updateByPrimaryKeySelective(Popedom record);

    int updateByPrimaryKeyWithBLOBs(Popedom record);

    int updateByPrimaryKey(Popedom record);
}