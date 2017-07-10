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

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleWithBLOBs> implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleWithBLOBs> listAll() {
        return roleDao.listAll();
    }

    @Override
    public DataModel<Role> listRoles(Role role, Pager pager) {
        DataModel<Role> dm = new DataModel<Role>();
        int total = roleDao.countRole(role.getName());

        pager.fixPage(total);

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

    @Override
    public RoleWithBLOBs getById(Integer edit_id) {
        return null;
    }

    @Override
    public DataModel<RoleWithBLOBs> list(Pager pager, RoleWithBLOBs roleWithBLOBs) {
        return null;
    }

    @Override
    public boolean save(RoleWithBLOBs roleWithBLOBs) {
        return false;
    }

    @Override
    public boolean update(RoleWithBLOBs roleWithBLOBs) {
        return false;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, RoleWithBLOBs roleWithBLOBs, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }
}
