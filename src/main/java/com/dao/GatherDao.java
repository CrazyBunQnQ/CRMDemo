package com.dao;

import com.bean.Gather;
import com.bean.GatherWithBLOBs;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface GatherDao {
    int deleteByPrimaryKey(Integer id);

    int insert(GatherWithBLOBs record);

    int insertSelective(GatherWithBLOBs record);

    GatherWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GatherWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(GatherWithBLOBs record);

    int updateByPrimaryKey(Gather record);
}