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

    @RequestMapping("/getPopedomTreeStr")
    public ModelAndView getPopedomTreeStr(Integer role_id, Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        String treeStr = popedomService.getTree();
        String dragStr = popedomService.getDrag(role_id, id, true);
        String popedom = popedomService.getPopedomByRoleId(role_id);

        modelAndView.addObject("role_id", role_id);
        modelAndView.addObject("treeStr", treeStr);
        modelAndView.addObject("tableStr", dragStr);
        modelAndView.setViewName("/jsp/role/popedomSet");
        return modelAndView;
    }

    public void setPopedomService(PopedomService popedomService) {
        this.popedomService = popedomService;
    }
}
