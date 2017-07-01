package com.controller;

import com.bean.ProductType;
import com.service.ProductTypeService;
import com.util.Constant;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j
@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/productTypeList")
    public ModelAndView findProductTypeList(Pager pager) {
        ModelAndView modelAndView = new ModelAndView();
        DataModel<ProductType> dm = productTypeService.findList(pager, new ProductType());

        //将查询的数据集合绑定到ModelAndView
        List<ProductType> rows = dm.getRows();
        for (ProductType some : rows) {
            log.info(some.getName());
        }
        modelAndView.addObject("rows", rows);
        //将分页相关的数据 绑定到ModelAndView
        modelAndView.addObject("pager", dm.getPager());
        modelAndView.setViewName("/jsp/productType/productTypeList");
        return modelAndView;
    }

    @RequestMapping("toAddProductType")
    public ModelAndView toAddProductType() {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productTypeAdd");
        String str = productTypeService.findProductTypeStr();
        modelAndView.addObject("selectOptionsStr", str);
        return modelAndView;
    }

    @RequestMapping("addProductType")
    public ModelAndView addProductType(ProductType productType) {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productypeAdd");
        boolean addSuccess = productTypeService.saveProductType(productType);
        String str = productTypeService.findProductTypeStr();
        modelAndView.addObject("suc", addSuccess ? Constant.ADD_SUCCESS : Constant.ADD_FAILURE);
        modelAndView.addObject("selectOptionStr", str);
        return modelAndView;
    }

    public void setProductTypeService(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
}
