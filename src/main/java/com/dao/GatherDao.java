package com.dao;

import com.bean.GatherWithBLOBs;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface GatherDao extends BaseDao<GatherWithBLOBs> {
    int deleteByPrimaryKey(Integer id);

    int insert(GatherWithBLOBs record);

    @Override
    int insertSelective(GatherWithBLOBs record);

    @Override
    GatherWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatherWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GatherWithBLOBs record);

    @Override
    int updateByPrimaryKey(GatherWithBLOBs record);
}