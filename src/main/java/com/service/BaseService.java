package com.service;

import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
public interface BaseService<S> {
    <T> DataModel<T> list(Pager pager, T t);

    boolean removeByIds(Integer[] selectedId);

    <T> boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, T t, HttpServletResponse response);

    <T> boolean save(T t);

    <T> boolean update(T t);

    <T> T getById(Integer edit_id);
}
