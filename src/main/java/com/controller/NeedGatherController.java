package com.controller;

import com.bean.NeedGather;
import com.service.NeedGatherService;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/9.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/needGather")
public class NeedGatherController extends BaseController<NeedGather> {
    @Autowired
    private NeedGatherService needGatherService;

    @Override
    @RequestMapping("/needGather/List")
    protected ModelAndView list(Pager pager, String isDel, Integer[] selectedId, NeedGather bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(needGatherService, pager, isDel, selectedId, bean, exportType, response);
        if (modelAndView == null) {
            return null;
        }

        modelAndView.setViewName("/jsp/gather/needGatherList");
        return modelAndView;
    }

    @Override
    @RequestMapping("toAddOrUpdate")
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(needGatherService, edit_id);
        modelAndView.setViewName("/jsp/gather/gatherAdd");
        return modelAndView;
    }

    @Override
    protected ModelAndView addOrUpdate(NeedGather bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(needGatherService, bean, edit_id);
        modelAndView.setViewName("/jsp/gather/gatherAdd");
        return modelAndView;
    }
}
