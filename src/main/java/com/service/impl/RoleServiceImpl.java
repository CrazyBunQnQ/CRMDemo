package com.service.impl;

import com.bean.Role;
import com.bean.RoleWithBLOBs;
import com.dao.RoleDao;
import com.service.RoleService;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public DataModel<Role> listRoles(Role role, Pager pager) {
        DataModel<Role> dm = new DataModel<Role>();
        List<Role> rows = roleDao.selectRoleByPage(role.getName(), pager.getFrom(), pager.getPageSize());
        dm.setRows(rows);
        int total = roleDao.countRole(role.getName());
        pager.setTotalRecord(total);
        dm.setPager(pager);
        return dm;
    }

    @Override
    public boolean saveRole(RoleWithBLOBs role) {
        return roleDao.insertSelective(role) > 0;
    }

    @Override
    public boolean removeRoleByIds(Integer[] ids) {
        return roleDao.deleteByPrimaryKeys(ids) > 0;
    }
}
