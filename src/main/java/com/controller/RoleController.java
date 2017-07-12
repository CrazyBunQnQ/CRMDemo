package com.controller;

import com.bean.Role;
import com.service.RoleService;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController<Role> {
    @Resource
    private RoleService roleService;

    @Override
    @RequestMapping("/roleList")
    protected ModelAndView list(Pager pager, String isDel, Integer[] selectedId, Role bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(roleService, pager, isDel, selectedId, bean, exportType, response);
        modelAndView.setViewName("/jsp/role/roleList");
        return modelAndView;
    }

    @Override
    @RequestMapping("/load4AddRole")
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(roleService, edit_id);
        modelAndView.setViewName("/jsp/role/roleAdd");
        return modelAndView;
    }

    @Override
    @RequestMapping("/roleAdd")
    protected ModelAndView addOrUpdate(Role bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(roleService, bean, edit_id);
        modelAndView.setViewName("/jsp/role/roleAdd");
        return modelAndView;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
