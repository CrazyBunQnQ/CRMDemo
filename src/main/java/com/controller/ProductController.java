package com.controller;

import com.bean.Product;
import com.service.ProductService;
import com.service.ProductTypeService;
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

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("productList")
    public ModelAndView listProduct(Pager pager, String isDel, Integer[] product_id, Product product, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/jsp/product/productList");

        if (exportType != null && !"".equals(exportType.trim())) {
            productService.exportExcel(exportType, pager, product_id, product, response);
            return null;
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
    public ModelAndView toAddProduct(Integer edit_id) {
        ModelAndView modelAndView = new ModelAndView("/jsp/product/productAdd");
        if (edit_id != null) {
            Product product = productService.getProductById(edit_id);
            modelAndView.addObject("product",product);
        }
        String selectOptionsStr = productTypeService.findProductTypeStr();
        log.error(selectOptionsStr);
        modelAndView.addObject("selectOptionsStr", selectOptionsStr);
        return modelAndView;
    }

    @RequestMapping("/addOrUpdateProduct")
    public ModelAndView saveOrUpdateProduct(Product product, Integer edit_id) {
        ModelAndView modelAndView = new ModelAndView("/jsp/product/productAdd");
        log.error(product.toString());
        boolean sussess = false;
        if (edit_id == null ) {
            sussess = productService.saveProduct(product);
            modelAndView.addObject("suc", sussess?Constant.ADD_SUCCESS:Constant.ADD_FAILURE);
        } else {
            product.setId(edit_id);
            sussess = productService.updateProduct(product);
            modelAndView.addObject("suc", sussess?Constant.UPDATE_SUCCESS:Constant.UPDATE_FAILURE);
        }

        String selectOptionsStr = productTypeService.findProductTypeStr();
        modelAndView.addObject("selectOptionStr", selectOptionsStr);
        return modelAndView;
    }

//    @RequestMapping("/")
}
