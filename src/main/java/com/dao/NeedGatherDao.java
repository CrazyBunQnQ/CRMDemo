package com.dao;

import com.bean.NeedGather;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface NeedGatherDao extends BaseDao<NeedGather> {
    int deleteByPrimaryKey(Integer id);

    int insert(NeedGather record);

    @Override
    int insertSelective(NeedGather record);

    @Override
    NeedGather selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NeedGather record);

    int updateByPrimaryKeyWithBLOBs(NeedGather record);

    @Override
    int updateByPrimaryKey(NeedGather record);
}