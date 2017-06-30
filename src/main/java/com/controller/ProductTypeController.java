package com.controller;

import com.bean.ProductType;
import com.service.ProductTypeService;
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
        ModelAndView mav = new ModelAndView();
        DataModel<ProductType> dm = productTypeService.findList(pager);


        //将查询的数据集合绑定到ModelAndView
        List<ProductType> rows = dm.getRows();
        for (ProductType some : rows) {
            log.info(some.getName());
        }
        mav.addObject("rows", rows);
        //将分页相关的数据 绑定到ModelAndView
        mav.addObject("pager", dm.getPager());
        mav.setViewName("/jsp/productType/productTypeList");
        return mav;
    }

    @RequestMapping("toAddProductType")
    public ModelAndView toAddProductType() {
        ModelAndView mav = new ModelAndView("/jsp/productType/productTypeAdd");
        String str = productTypeService.findProductTypeStr();
        mav.addObject("selectOptionsStr", str);
        return mav;
    }

    public void setProductTypeService(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
}
