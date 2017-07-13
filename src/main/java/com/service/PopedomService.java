package com.service;

import com.bean.Popedom;

import java.util.List;

/**
 * @version 2017/7/1.
 * @auther CrazyBunQnQ
 */
public interface PopedomService {

    public String getPopedomByRoleId(Integer id);

    public String getTree();

    public List<Popedom> listPopedom();

    String getDrag(Integer role_id, Integer id, boolean enable);
}
