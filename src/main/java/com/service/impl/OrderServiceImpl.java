package com.service.impl;

import com.bean.Order;
import com.dao.OrderDao;
import com.service.BaseService;
import com.service.OrderService;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Order getById(Integer edit_id) {
        return null;
    }

    @Override
    public List<Order> list(Pager pager, Order order) {
        return null;
    }

    @Override
    public boolean save(Order order) {
        return false;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, Order order, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }
}
