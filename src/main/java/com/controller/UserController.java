package com.controller;

import com.bean.User;
import com.service.UserService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @version 2017/7/8.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController<User> {
    @Autowired
    private UserService userService;

    @Override
    public ModelAndView list(Pager pager, String isDel, Integer[] selectedId, User bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(userService, pager, isDel, selectedId, bean, exportType, response);
        if (modelAndView == null) {
            return null;
        }

        modelAndView.setViewName("/jsp/user/userList");
        return modelAndView;
    }

    @RequestMapping("/userList")
    public ModelAndView changeStatus(Pager pager, String isDel, Integer[] selectedId, User bean, String exportType, HttpServletResponse response, String changeStatus) {
        ModelAndView modelAndView = new ModelAndView();

        if (changeStatus == null || "".equals(changeStatus)) {
            modelAndView = list(pager,isDel,selectedId,bean,exportType,response);
            return modelAndView;
        } else if (Constant.ENABLE.equals(changeStatus)) {
            modelAndView.addObject("suc", userService.enableByIds(selectedId) ? Constant.ENABLE_SUCCESS : Constant.ENABLE_FAILURE);
        } else if (Constant.DISABLE.equals(changeStatus)) {
            modelAndView.addObject("suc", userService.disableByIds(selectedId) ? Constant.DISABLE_SUCCESS : Constant.DISABLE_FAILURE);
        }

        DataModel<User> dataModel = userService.list(pager, bean);

        List<User> rows = dataModel.getRows();
        modelAndView.addObject("rows", rows);
        modelAndView.addObject("pager", dataModel.getPager());
        modelAndView.setViewName("/jsp/user/userList");
        return modelAndView;
    }

    @Override
    @RequestMapping("/toAddOrUpdate")
    public ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(userService, edit_id);
        modelAndView.setViewName("/jsp/user/userAdd");

        //TODO roleList
        //TODO accessGroupList
        //TODO groupList
        return modelAndView;
    }

    @Override
    @RequestMapping("/addOrUpdate")
    public ModelAndView addOrUpdate(User bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(userService, bean, edit_id);
        modelAndView.setViewName("/jsp/user/userAdd");
        return modelAndView;
    }
}
