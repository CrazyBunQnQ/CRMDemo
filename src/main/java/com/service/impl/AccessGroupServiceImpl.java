package com.service.impl;

import com.bean.AccessGroup;
import com.dao.AccessGroupDao;
import com.service.AccessGroupService;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/10.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class AccessGroupServiceImpl extends BaseServiceImpl<AccessGroup> implements AccessGroupService {
    @Autowired
    private AccessGroupDao accessGroupDao;

    @Override
    public List<AccessGroup> listAll() {
        return accessGroupDao.listAll();
    }

    @Override
    public AccessGroup getById(Integer edit_id) {
        return null;
    }

    @Override
    public DataModel<AccessGroup> list(Pager pager, AccessGroup accessGroup) {
        return null;
    }

    @Override
    public boolean save(AccessGroup accessGroup) {
        return false;
    }

    @Override
    public boolean update(AccessGroup accessGroup) {
        return false;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, AccessGroup accessGroup, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }
}
