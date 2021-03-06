package com.controller;

import com.bean.Order;
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
public class OrderController extends BaseController<Order> {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping("/orderList")
    public ModelAndView list(Pager pager, String isDel, Integer[] selectedId, Order order, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = super.baseList(orderService, pager, isDel, selectedId, order, exportType, response);
        if (modelAndView == null) {
            return null;
        }
        modelAndView.setViewName("/jsp/order/orderList");
        return modelAndView;
    }

    @Override
    @RequestMapping("/toAddOrUpdateOrder")
    protected ModelAndView toAddOrUpdate(Integer edit_id) {
        ModelAndView modelAndView = super.baseToAddOrUpdate(orderService, edit_id);
        modelAndView.setViewName("/jsp/order/orderAdd");

        //TODO 业务员列表

        return modelAndView;
    }

    @Override
    @RequestMapping("/addOrUpdateOrder")
    protected ModelAndView addOrUpdate(Order bean, Integer edit_id) {
        // TODO 拥有者
        if (bean.getOwnerUsr() == null) {
            bean.setOwnerUsr(1);
        }
        if (bean.getCusId() == null) {
            bean.setCusId(1);
        }

        ModelAndView modelAndView = super.baseAddOrUpdate(orderService, bean, edit_id);
        modelAndView.setViewName("/jsp/order/orderAdd");

        // TODO 业务员列表

        return modelAndView;
    }
}
