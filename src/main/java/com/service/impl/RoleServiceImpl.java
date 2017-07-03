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
        int total = roleDao.countRole(role.getName());

        int num = (pager.getPage()-1) * pager.getPageSize();//理论上的总数

        if (total < pager.getPageSize()) {
            pager.setPage(1);
        } else if (total > pager.getPageSize() && total < num) {
            pager.setPage(num / total + 1);
        }

        List<Role> rows = roleDao.selectRoleByPage(role.getName(), pager.getFrom(), pager.getPageSize());
        dm.setRows(rows);
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
