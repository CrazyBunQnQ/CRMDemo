package com.service.impl;

import com.service.OrderService;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public <T> DataModel<T> list(Pager pager, T t) {
        return null;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }

    @Override
    public <T> boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, T t, HttpServletResponse response) {
        return false;
    }

    @Override
    public <T> boolean save(T t) {
        return false;
    }

    @Override
    public <T> boolean update(T t) {
        return false;
    }

    @Override
    public <T> T getById(Integer edit_id) {
        return null;
    }
}