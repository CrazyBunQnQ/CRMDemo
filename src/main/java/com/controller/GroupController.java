package com.controller;

import com.bean.UserGroup;
import com.service.GroupService;
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
@RequestMapping("/group")
public class GroupController extends BaseController<UserGroup> {
    @Autowired
    private GroupService groupService;

    @Override
    protected ModelAndView list(Pager pager, String isDel, Integer[] selectedId, UserGroup bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(groupService, pager,isDel, selectedId, bean, exportType, response);
        if(modelAndView == null) {
            return null;
        }

        modelAndView.setViewName("/jsp/group/userGroupList");
        return modelAndView;
    }

    @Override
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(groupService, edit_id);
        modelAndView.setViewName("/jsp/group/userGroupAdd");
        return modelAndView;
    }

    @Override
    protected ModelAndView addOrUpdate(UserGroup bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(groupService, bean, edit_id);
        modelAndView.setViewName("/jsp/group/userGroupAdd");
        return modelAndView;
    }
}
