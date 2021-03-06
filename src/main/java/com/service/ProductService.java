package com.service;

import com.bean.Product;
import com.util.DataModel;
import com.util.Pager;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 2017/7/3.
 * @auther CrazyBunQnQ
 */
public interface ProductService {
    DataModel<Product> listProduct(Pager pager, Product product);

    boolean removeProductByIds(Integer[] product_id);

    boolean exportExcel(String exportType, Pager pager, Integer[] product_id, Product product, HttpServletResponse response);

    boolean saveProduct(Product product);

    boolean updateProduct(Product product);

    Product getProductById(Integer edit_id);
}
