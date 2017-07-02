package com.service;


import com.bean.ProductType;
import com.util.DataModel;
import com.util.Pager;

import javax.servlet.http.HttpServletResponse;

public interface ProductTypeService {
    /**
     * 查询数据页号下相关内容(包括模糊查询)
     *
     * @param pager
     * @param productType
     *
     * @return
     */
    public DataModel<ProductType> findList(Pager pager, ProductType productType);

    /**
     * 拼接类似:
     * <option value='id'>名称
     */
    public String findProductTypeStr();

    public boolean saveProductType(ProductType productType);

    public ProductType getProductTypeById(Integer productTypeId);

    public boolean updateProductType(ProductType productType);

    public String removeProductType(Integer[] productType_id);

    public String findTree();

    /**
     * 导出 excel 报表
     *
     * @param exportType     导出类型（excel_all, excel_page, excel_selected）
     * @param pager          如果导出当前页则需要获取页号
     * @param productType_id 如果导出选中的则需要获取选中的 id 数组
     * @param productType    如果有过滤条件的话需要封装查询条件
     * @param response       获取输出流
     */
    public boolean exportExcel(String exportType, Pager pager, Integer[] productType_id, ProductType productType, HttpServletResponse response);
}
