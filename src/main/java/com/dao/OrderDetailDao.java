package com.dao;

import com.bean.OrderDetail;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface OrderDetailDao extends BaseDao<OrderDetail> {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}