package com.controller;

import com.bean.Popedom;
import com.bean.Role;
import com.service.PopedomService;
import com.service.RoleService;
import com.util.Constant;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    private PopedomService popedomService;

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

    /**
     * 跳转到权限前操作
     */
    @RequestMapping("toSetPopedom")
    public ModelAndView toSetPopedom(Integer role_id) {
        ModelAndView mav = new ModelAndView();
        //查询所有权限
        List<Popedom> list = roleService.findAllPopedomList(role_id);
        mav.addObject("role_id", role_id);
        mav.addObject("list", list);
        mav.setViewName("/jsp/role/popedomSet");
        return mav;
    }

    /**
     * 设置权限
     */
    @RequestMapping("setPopedom")
    public ModelAndView setPopedom(Integer role_id, Integer[] popedomValue) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("suc", roleService.updatePopedom(role_id, popedomValue) ? Constant.SET_SUCCESS : Constant.SET_FAILURE);
        mav.addObject("role_id", role_id);
//        mav.addObject("list", roleService.findAllPopedomList(role_id));
        String treeStr = popedomService.getTree();
        String dragStr = popedomService.getDrag(role_id, 0, true);

        mav.addObject("treeStr", treeStr);
        mav.addObject("tableStr", dragStr);
        mav.setViewName("/jsp/role/popedomSet");
        return mav;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
