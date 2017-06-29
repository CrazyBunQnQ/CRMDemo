package com.controller;

import com.bean.User;
import com.service.UserService;
import com.util.Constant;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String name, String password, String verifyCode, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String sessionCode = (String) session.getAttribute(Constant.CHECK_CODE);
        if (sessionCode != null && sessionCode.equalsIgnoreCase(verifyCode)) {
            User user = userService.findUser(name, password);
            if (user != null) {
                if (Constant.START_USING.equals(user.getStatus())) {
                    modelAndView.setViewName("redirect:toMain");
                } else {
                    modelAndView.addObject("err", Constant.USER_IS_DISABLE);
                    modelAndView.setViewName("/login");
                }
            } else {
                modelAndView.addObject("err", Constant.USER_NAME_OR_PASSWORD_ERROR);
                modelAndView.setViewName("/login");
            }
        } else {
            modelAndView.addObject("err", Constant.VERIFICATION_CODE_ERROR);
            modelAndView.setViewName("/login");
        }
        return modelAndView;
    }

    @RequestMapping("toMain")
    public ModelAndView toMain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/main");
        return modelAndView;
    }
}
