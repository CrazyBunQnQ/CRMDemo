package com.dao;

import com.bean.Order;
import com.bean.OrderWithBLOBs;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface OrderDao extends BaseDao<OrderWithBLOBs> {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderWithBLOBs record);

    @Override
    int insertSelective(OrderWithBLOBs record);

    @Override
    OrderWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderWithBLOBs record);

    @Override
    int updateByPrimaryKey(OrderWithBLOBs record);
}