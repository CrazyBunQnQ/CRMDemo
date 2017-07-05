package com.controller;

import com.service.OrderService;
import lombok.*;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
}
