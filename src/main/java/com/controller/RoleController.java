package com.controller;

import com.bean.Role;
import com.bean.RoleWithBLOBs;
import com.service.RoleService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
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
    public ModelAndView selectRoleList(Role role, Pager pager, String isDel, String exportType, Integer[] role_id) {
        ModelAndView modelAndView = new ModelAndView();

        if (exportType != null && !exportType.trim().isEmpty()) {

            return null;
        }

        if (Constant.IS_DEL.equals(isDel)) {
            for (int i : role_id) {
//                log.info("role ids: " + role_id.length);
                log.info("role_id:" + i);
            }
            roleService.removeRoleByIds(role_id);
        }

        DataModel<Role> dm = roleService.listRoles(role, pager);

        List<Role> rows = dm.getRows();
        for (Role some : rows) {
            log.info(some.getName());
        }
        modelAndView.addObject("rows", rows);
        modelAndView.addObject("pager", dm.getPager());
        modelAndView.setViewName("/jsp/role/roleList");

        return modelAndView;
    }

    @RequestMapping("/load4AddRole")
    public ModelAndView load4AddRole() {
        ModelAndView modelAndView = new ModelAndView("/jsp/role/roleAdd");

        return modelAndView;
    }

    @RequestMapping("/roleAdd")
    public ModelAndView insertRole(RoleWithBLOBs role) {
        ModelAndView modelAndView = new ModelAndView();
        boolean addSuccess = roleService.saveRole(role);
        modelAndView.setViewName(addSuccess ? "redirect:roleList" : "redirect:roleAdd");

        return modelAndView;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
