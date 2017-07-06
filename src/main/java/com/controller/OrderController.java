package com.controller;

import com.bean.Order;
import com.service.OrderService;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController<OrderService> {
    @Override
    public <T> ModelAndView list(Pager pager, String isDel, Integer[] selectedId, T t, String exportType, HttpServletResponse response) {
        return super.list(pager, isDel, selectedId, t, exportType, response);
    }





    /*@RequestMapping("/orderList")
    public ModelAndView listOrder(Pager pager, String idDel, Integer[] order_id, Order order, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/jsp/order/productList");

        return modelAndView;
    }*/
}
