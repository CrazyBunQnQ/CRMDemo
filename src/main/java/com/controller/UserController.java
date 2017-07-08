package com.controller;

import com.bean.User;
import com.service.UserService;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

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
    @RequestMapping("/userList")
    protected ModelAndView list(Pager pager, String isDel, Integer[] selectedId, User bean, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baselist(userService, pager, isDel, selectedId, bean, exportType, response);
        if (modelAndView == null) {
            return null;
        }

        modelAndView.addObject("bean", bean);
        modelAndView.setViewName("/jsp/user/userList");
        return modelAndView;
    }

    @Override
    @RequestMapping("/toAddOrUpdate")
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(userService, edit_id);
        modelAndView.setViewName("/jsp/user/userAdd");

        return modelAndView;
    }

    @Override
    @RequestMapping("/addOrUpdate")
    protected ModelAndView addOrUpdate(User bean, Integer edit_id) {
        ModelAndView modelAndView = super.baseAddOrUpdate(userService, bean, edit_id);
        modelAndView.setViewName("/jsp/user/userAdd");
        return modelAndView;
    }
}
