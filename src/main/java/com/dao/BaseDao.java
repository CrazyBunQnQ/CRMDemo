package com.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
public interface BaseDao<B> {
    int count(@Param("bean") B b);

    List<B> listByPage(@Param("from") int from, @Param("pageSize") int pageSize, @Param("bean") B b);

    List<B> listAll();

    List<B> listSelected(@Param("ids") Integer[] ids);

    int removeByPrimaryKeys(@Param("ids") Integer[] ids);

    int insertSelective(B b);

    int updateByPrimaryKey(B b);

    B selectByPrimaryKey(Integer edit_id);
}
