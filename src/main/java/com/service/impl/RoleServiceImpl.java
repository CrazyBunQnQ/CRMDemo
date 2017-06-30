package com.service.impl;

import com.bean.Role;
import com.dao.RoleDao;
import com.service.RoleService;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Paper;
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

    public DataModel<Role> selectList(Pager pager) {
        DataModel<Role> dm = new DataModel<Role>();
        List<Role> rows = roleDao.selectRoleByPage(pager.getFrom(), pager.getPageSize());
        dm.setRows(rows);
        int total = roleDao.countRole();
        pager.setTotalRecord(total);
        dm.setPager(pager);
        return dm;
    }
}
