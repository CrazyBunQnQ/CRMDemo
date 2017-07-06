package com.controller;

import com.service.BaseService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by HCol on 2017/7/6.
 */
public abstract class BaseController<B> {

    protected abstract ModelAndView list(Pager pager, String isDel, Integer[] selectedId, B bean, String exportType, HttpServletResponse response);

    protected ModelAndView baselist(BaseService service, Pager pager, String isDel, Integer[] selectedId, B bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();

        if (exportType != null && !"".equals(exportType.trim())) {
            service.exportExcel(exportType, pager, selectedId, bean, response);
        }

        if (Constant.IS_DEL.equals(isDel)) {
            modelAndView.addObject("suc", service.removeByIds(selectedId) ? Constant.REMOVE_SUCCESS : Constant.REMOVE_FAILURE);
        }

        DataModel<B> dataModel = service.list(pager, bean);

        List<B> rows = dataModel.getRows();
        modelAndView.addObject("rows", rows);
        modelAndView.addObject("pager", dataModel.getPager());
        return modelAndView;
    }
}
