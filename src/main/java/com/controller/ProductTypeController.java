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

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j
@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping("/productTypeList")
    public ModelAndView findProductTypeList(Pager pager, String isDel, Integer[] productType_id, ProductType productType, String exportType, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productTypeList");
        boolean success = false;

        if (exportType != null && !"".equals(exportType.trim())) {
            success = productTypeService.exportExcel(exportType, pager, productType_id, productType, response);
            modelAndView.addObject("suc", success ? Constant.EXPORT_SUCCESS : Constant.EXPORT_FAILURE);
            return modelAndView;
        }

        if (Constant.IS_DEL.equals(isDel)) {//批量删除
            modelAndView.addObject("suc", productTypeService.removeProductType(productType_id));
        }

        DataModel<ProductType> dm = productTypeService.findList(pager, productType);

        //将查询的数据集合绑定到ModelAndView
        List<ProductType> rows = dm.getRows();
        modelAndView.addObject("rows", rows);

        //将分页相关的数据 绑定到ModelAndView
        modelAndView.addObject("pager", dm.getPager());
        return modelAndView;
    }

    @RequestMapping("/toAddProductType")
    public ModelAndView toAddProductType() {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productTypeAdd");
        String str = productTypeService.findProductTypeStr();
        modelAndView.addObject("selectOptionsStr", str);
        return modelAndView;
    }

    /**
     * 添加或更新商品类
     *
     * @param productType 需要添加或者修改的商品类
     * @param edit_id     隐藏域中标识修改的商品类 id
     *
     * @return
     */
    @RequestMapping("/addOrUpdateProductType")
    public ModelAndView saveOrUpdateProductType(ProductType productType, Integer edit_id) {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productTypeAdd");
        boolean success = false;
        String str;
        if (edit_id == null) {//新建 保存
            success = productTypeService.saveProductType(productType);
            modelAndView.addObject("suc", success ? Constant.ADD_SUCCESS : Constant.ADD_FAILURE);
        } else {//修改 保存
            productType.setId(edit_id);
            success = productTypeService.updateProductType(productType);
            modelAndView.addObject("suc", success ? Constant.UPDATE_SUCCESS : Constant.UPDATE_FAILURE);
        }
        str = productTypeService.findProductTypeStr();
        modelAndView.addObject("selectOptionsStr", str);
        return modelAndView;
    }

    /**
     * 跳转到修改页面
     *
     * @param productTypeId
     *
     * @return
     */
    @RequestMapping("/toUpdateProductType")
    public ModelAndView toUpdateProductType(Integer productTypeId) {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/productTypeAdd");
        ProductType productType = productTypeService.getProductTypeById(productTypeId);
        modelAndView.addObject("productType", productType);
        String str = productTypeService.findProductTypeStr();
        modelAndView.addObject("selectOptionsStr", str);
        return modelAndView;
    }

    @RequestMapping("/optionTreeWindow")
    public ModelAndView optionTreeWindow() {
        ModelAndView modelAndView = new ModelAndView("/jsp/productType/treeWindow");
        String tree = productTypeService.findTree();
        modelAndView.addObject("treeStr", tree);
        return modelAndView;
    }

    @RequestMapping("getSelectOptionsStr")
    public String getProductTypeStr() {
        return productTypeService.findProductTypeStr();
    }

    public void setProductTypeService(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }
}
