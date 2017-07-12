package com.service.impl;

import com.bean.Role;
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
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listAll() {
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
    public boolean saveRole(Role role) {
        return roleDao.insertSelective(role) > 0;
    }

    @Override
    public boolean removeRoleByIds(Integer[] ids) {
        return roleDao.deleteByPrimaryKeys(ids) > 0;
    }

    @Override
    public Role getById(Integer edit_id) {
        return super.baseGetById(roleDao, edit_id);
    }

    @Override
    public DataModel<Role> list(Pager pager, Role role) {
        return super.baseList(roleDao, pager, role);
    }

    @Override
    public boolean save(Role role) {
        return super.baseSave(roleDao, role);
    }

    @Override
    public boolean update(Role role) {
        return super.baseUpdate(roleDao, role);
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, Role role, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }
}
