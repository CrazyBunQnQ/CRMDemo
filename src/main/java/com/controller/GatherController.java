package com.controller;

import com.service.GatherService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/gather")
public class GatherController {
    @Autowired
    private GatherService gatherService;
}
