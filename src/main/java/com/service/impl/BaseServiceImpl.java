package com.service.impl;

import com.dao.BaseDao;
import com.service.BaseService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
public abstract class BaseServiceImpl<B> implements BaseService<B> {

    public DataModel<B> list(BaseDao baseDao, Pager pager, B b) {

        DataModel<B> dataModel = new DataModel<B>();
        int total = baseDao.count(b);
        pager.fixPage(total);
        List<B> rows = baseDao.listByPage(pager.getFrom(), pager.getPageSize(), b);

        pager.setTotalRecord(total);
        dataModel.setRows(rows);
        dataModel.setPager(pager);
        return dataModel;
    }

    public boolean removeByIds(BaseDao baseDao, Integer[] selectedId) {
        return baseDao.removeByPrimaryKeys(selectedId) > 0;
    }

    public boolean save(BaseDao baseDao, B b) {
        return baseDao.insertSelective(b) > 0;
    }

    public boolean update(BaseDao baseDao, B b) {
        return baseDao.updateByPrimaryKey(b) > 0;
    }

    public B getById(BaseDao baseDao, Integer edit_id) {
        return (B) baseDao.selectByPrimaryKey(edit_id);
    }

    protected List<B> export(BaseDao baseDao, String exportType, Pager pager, Integer[] selectedId, B b, HttpServletResponse response) {
        List<B> list = null;

        switch (exportType) {
            case Constant.EXPORT_ALL:
                list = baseDao.listAll();
                break;
            case Constant.EXPORT_PAGE:
                list = baseDao.listByPage(pager.getFrom(), pager.getPageSize(), b);
                break;
            case Constant.EXPORT_SELECTED:
                list = baseDao.listSelected(selectedId);
                break;
            default:
        }
        return list;
    }
}
