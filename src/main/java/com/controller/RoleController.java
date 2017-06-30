package com.controller;

import com.bean.Role;
import com.service.RoleService;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 2017/6/30.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping("/roleList")
    public ModelAndView selectRoleList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView();
        DataModel<Role> dm = roleService.selectList(pager);

        List<Role> rows = dm.getRows();
        for (Role role:rows) {
            log.info(role.getName());
        }
        modelAndView.addObject("rows",rows);
        modelAndView.addObject("pager",dm.getPager());
        modelAndView.setViewName("/jsp/role/roleList");

        return modelAndView;
    }
}
