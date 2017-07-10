package com.service;

import com.util.DataModel;
import com.util.Pager;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by CrazyBunQnQ on 2017/7/6.
 */
public interface BaseService<B> {

    B getById(Integer edit_id);

    DataModel<B> list(Pager pager, B b);

    boolean save(B b);

    boolean update(B b);

    boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, B b, HttpServletResponse response);

    boolean removeByIds(Integer[] selectedId);
}
