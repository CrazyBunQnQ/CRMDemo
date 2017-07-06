package com.controller;

import com.service.BaseService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
public class BaseController<S> {
    @Autowired
    protected BaseService<S> baseService;
    protected String pathName;

    public <T> ModelAndView list(Pager pager, String isDel, Integer[] selectedId, T t, String exportType, HttpServletResponse response) {
        String className = getClass().getName();
        pathName = className.substring(0, className.indexOf("Controller"));
        ModelAndView modelAndView = new ModelAndView("/jsp/" + pathName + "/" + pathName + "List");

        if (exportType != null && !"".equals(exportType.trim())) {
            baseService.exportExcel(exportType, pager, selectedId, t, response);
            return null;
        }

        if (Constant.IS_DEL.equals(isDel.trim())) {
            modelAndView.addObject("suc", baseService.removeByIds(selectedId)?Constant.REMOVE_SUCCESS:Constant.REMOVE_FAILURE);
        }

        DataModel<T> dataModel = baseService.list(pager, t);

        List<T> rows = dataModel.getRows();
        modelAndView.addObject("rows", rows);
        modelAndView.addObject("pager", dataModel.getPager());

        return modelAndView;
    }
}
