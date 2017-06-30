package com.service;


import com.bean.ProductType;
import com.util.DataModel;
import com.util.Pager;

public interface ProductTypeService {
    /**
     * 查询数据页号下相关内容
     *
     * @param pager
     *
     * @return
     */
    public DataModel<ProductType> findList(Pager pager);

    public String findProductTypeStr();
}
