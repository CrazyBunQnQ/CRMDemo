package com.dao;

import com.bean.Order;
import com.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface OrderDao extends BaseDao<Order> {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    @Override
    int insertSelective(Order record);

    @Override
    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKeyWithBLOBs(Order record);

    @Override
    int updateByPrimaryKey(Order record);

    List<Order> findOrderList(@Param("order") Order order, @Param("user") User user);

    List<Order> listAllOrder(@Param("user") User user);

    List<Order> findSelectedOrder(@Param("ids") Integer[] ids);

    int countOrder(@Param("order") Order order, @Param("user") User user);

    List<Order> findOwnerList(@Param("user") User user);
}