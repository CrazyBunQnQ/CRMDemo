package com.controller;

import com.bean.User;
import com.bean.UserGroup;
import com.service.UserGroupService;
import com.util.Constant;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/9.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/group")
public class UserGroupController extends BaseController<UserGroup> {
    @Autowired
    private UserGroupService userGroupService;

    @Override
    @RequestMapping("/groupList")
    protected ModelAndView list(Pager pager, String isDel, Integer[] selectedId, UserGroup bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(userGroupService, pager, isDel, selectedId, bean, exportType, response);
        if (modelAndView == null) {
            return null;
        }

        modelAndView.setViewName("/jsp/group/userGroupList");
        return modelAndView;
    }

    @Override
    @RequestMapping("/toAddOrUpdate")
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(userGroupService, edit_id);
        modelAndView.setViewName("/jsp/group/userGroupAdd");
        return modelAndView;
    }

    @Override
    @RequestMapping("/addOrUpdate")
    protected ModelAndView addOrUpdate(UserGroup bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(userGroupService, bean, edit_id);
        modelAndView.setViewName("/jsp/group/userGroupAdd");
        return modelAndView;
    }

    @RequestMapping("/optionTreeWindow")
    public ModelAndView optionTreeWindow() {
        ModelAndView modelAndView = new ModelAndView("/treeWindow");
        String tree = userGroupService.getTree();
        modelAndView.addObject("treeStr", tree);
        return modelAndView;
    }

    @RequestMapping("/toSetUserGroup")
    public ModelAndView toSetGroup(Integer id) {
        ModelAndView modelAndView = new ModelAndView("/jsp/group/setUser");

        List<User> userList = userGroupService.listUserNotByGroupId(id);
        List<User> curGroupUsers = userGroupService.listUserByGroupId(id);

        modelAndView.addObject("userList", userList);
        modelAndView.addObject("curGroupUsers", curGroupUsers);
        return modelAndView;
    }
    @RequestMapping("/setUserGroup")
    public ModelAndView setUserGroup(Integer id, String ids) {
        ModelAndView modelAndView = new ModelAndView("/jsp/group/setUser");

        modelAndView.addObject(userGroupService.setUser(id, ids)? Constant.SET_SUCCESS:Constant.SET_FAILURE);

        List<User> userList = userGroupService.listUserNotByGroupId(id);
        List<User> curGroupUsers = userGroupService.listUserByGroupId(id);

        modelAndView.addObject("userList", userList);
        modelAndView.addObject("curGroupUsers", curGroupUsers);
        return modelAndView;
    }
}
