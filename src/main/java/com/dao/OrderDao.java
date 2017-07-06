package com.dao;

import com.bean.Order;
import com.bean.OrderWithBLOBs;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface OrderDao extends BaseDao<Order> {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderWithBLOBs record);

    int insertSelective(OrderWithBLOBs record);

    OrderWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderWithBLOBs record);

    int updateByPrimaryKey(Order record);
}