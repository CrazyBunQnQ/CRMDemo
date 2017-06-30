package com.service;

import com.bean.Role;
import com.util.DataModel;
import com.util.Pager;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
public interface RoleService {

    /**
     * Paging search role
     *
     * @param pager
     *
     * @return
     */
    public DataModel<Role> selectList(Pager pager);
}
