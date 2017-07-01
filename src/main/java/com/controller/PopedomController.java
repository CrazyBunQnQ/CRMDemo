package com.controller;

import com.service.PopedomService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 2017/7/1.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/popedom")
public class PopedomController {
    @Autowired
    private PopedomService popedomService;

    @RequestMapping("getPopedomTreeStr")
    public ModelAndView getPopedomTreeStr() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/jsp/role/popedomSet");
        return modelAndView;
    }

    public void setPopedomService(PopedomService popedomService) {
        this.popedomService = popedomService;
    }
}
