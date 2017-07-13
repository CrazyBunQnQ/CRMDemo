package com.service;

import com.bean.Popedom;
import com.bean.Role;
import com.util.DataModel;
import com.util.Pager;

import java.util.List;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
public interface RoleService extends BaseService<Role> {

    /**
     * Paging search role
     *
     * @param pager
     *
     * @return
     */
    public DataModel<Role> listRoles(Role role, Pager pager);

    public boolean saveRole(Role role);

    /**
     * According to the id array batch remove roles
     *
     * @param ids
     *
     * @return
     */
    public boolean removeRoleByIds(Integer[] ids);

    List<Role> listAll();

    List<Popedom> findAllPopedomList(Integer role_id);

    boolean updatePopedom(Integer role_id, Integer[] popedomValue);
}
