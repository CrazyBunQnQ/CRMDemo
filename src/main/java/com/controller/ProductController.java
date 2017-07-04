package com.controller;

import com.bean.Product;
import com.service.ProductService;
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
 * @version 2017/7/3.
 * @auther CrazyBunQnQ
 */
@Log4j
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("productList")
    public ModelAndView listProduct(Pager pager, String isDel, Integer[] product_id, Product product, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/jsp/product/productList");
        boolean success = false;

        if (exportType != null && !"".equals(exportType.trim())) {
            success = productService.exportExcel(exportType, pager, product_id, product, response);
            modelAndView.addObject("suc", success ? Constant.EXPORT_SUCCESS : Constant.EXPORT_FAILURE);
            return modelAndView;
        }

        if (Constant.IS_DEL.equals(isDel)) {
            modelAndView.addObject("suc", productService.removeProductByIds(product_id) ? Constant.REMOVE_SUCCESS : Constant.REMOVE_FAILURE);
        }

        DataModel<Product> dataModel = productService.listProduct(pager, product);

        List<Product> rows = dataModel.getRows();
        modelAndView.addObject("rows", rows);
        modelAndView.addObject("pager", dataModel.getPager());
        return modelAndView;
    }

    @RequestMapping("/toAddProduct")
    public ModelAndView toAddProduct() {
        ModelAndView modelAndView = new ModelAndView("/jsp/product/productAdd");
//        String str = productService.getProductStr();
//        modelAndView.addObject("")
        return modelAndView;
    }
}
