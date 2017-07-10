package com.service.impl;

import com.bean.AccessGroupWithBLOBs;
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
public class AccessGroupServiceImpl extends BaseServiceImpl<AccessGroupWithBLOBs> implements AccessGroupService {
    @Autowired
    private AccessGroupDao accessGroupDao;

    @Override
    public List<AccessGroupWithBLOBs> listAll() {
        return accessGroupDao.listAll();
    }

    @Override
    public AccessGroupWithBLOBs getById(Integer edit_id) {
        return null;
    }

    @Override
    public DataModel<AccessGroupWithBLOBs> list(Pager pager, AccessGroupWithBLOBs accessGroup) {
        return null;
    }

    @Override
    public boolean save(AccessGroupWithBLOBs accessGroup) {
        return false;
    }

    @Override
    public boolean update(AccessGroupWithBLOBs accessGroup) {
        return false;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] selectedId, AccessGroupWithBLOBs accessGroup, HttpServletResponse response) {
        return false;
    }

    @Override
    public boolean removeByIds(Integer[] selectedId) {
        return false;
    }
}
