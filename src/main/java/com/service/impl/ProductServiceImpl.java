package com.service.impl;

import com.bean.Product;
import com.dao.ProductDao;
import com.service.ProductService;
import com.util.DataModel;
import com.util.Pager;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/3.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public DataModel<Product> listProduct(Pager pager, Product product) {
        DataModel<DataModel> dataModel = new DataModel<>();

        return null;
    }

    @Override
    public Object removeProduct(Integer[] product_id) {
        return null;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] product_id, Product product, HttpServletResponse response) {
        return false;
    }
}
