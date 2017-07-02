package com.service;

import com.bean.Role;
import com.bean.RoleWithBLOBs;
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
    public DataModel<Role> listRoles(Role role, Pager pager);

    public boolean saveRole(RoleWithBLOBs role);

    /**
     * According to the id array batch remove roles
     *
     * @param ids
     *
     * @return
     */
    public boolean removeRoleByIds(Integer[] ids);
}
