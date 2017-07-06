package com.controller;

import com.bean.OrderWithBLOBs;
import com.service.OrderService;
import com.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by HCol on 2017/7/6.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController<OrderWithBLOBs> {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping("/orderList")
    public ModelAndView list(Pager pager, String isDel, Integer[] selectedId, OrderWithBLOBs order, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baselist(orderService, pager, isDel, selectedId, order, exportType, response);
        modelAndView.setViewName("/jsp/order/orderList");
        return modelAndView;
    }
}
