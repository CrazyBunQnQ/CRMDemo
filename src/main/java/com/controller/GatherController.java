package com.controller;

import com.bean.GatherWithBLOBs;
import com.service.GatherService;
import com.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Controller
@RequestMapping("/gather")
public class GatherController extends BaseController<GatherWithBLOBs> {
    @Autowired
    private GatherService gatherService;

    @Override
    @RequestMapping("/gatherList")
    public ModelAndView list(Pager pager, String isDel, Integer[] selectedId, GatherWithBLOBs bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(gatherService, pager, isDel, selectedId, bean, exportType, response);
        if (modelAndView == null) {
            return null;
        }

        modelAndView.setViewName("/jsp/gather/gatherList");
        return modelAndView;
    }

    @Override
    @RequestMapping("toAddOrUpdateGather")
    public ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(gatherService, edit_id);
        modelAndView.setViewName("/jsp/gather/gatherAdd");
        return modelAndView;
    }

    @Override
    @RequestMapping("addOrUpdateGather")
    public ModelAndView addOrUpdate(GatherWithBLOBs bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(gatherService, bean, edit_id);
        modelAndView.setViewName("/jsp/gather/gatherAdd");
        return modelAndView;
    }
}
