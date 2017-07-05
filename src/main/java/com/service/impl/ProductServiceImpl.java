package com.service.impl;

import com.bean.Product;
import com.dao.ProductDao;
import com.service.ProductService;
import com.util.DataModel;
import com.util.Pager;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
        DataModel<Product> dataModel = new DataModel<Product>();

        int total = productDao.countProduct(product);
        pager.fixPage(total);
        List<Product> rows = productDao.listProductByPage(pager.getFrom(), pager.getPageSize(), product);

        pager.setTotalRecord(total);
        dataModel.setRows(rows);
        dataModel.setPager(pager);
        return dataModel;
    }

    @Override
    public boolean removeProductByIds(Integer[] product_id) {
        return productDao.removeByPrimaryKeys(product_id) > 0;
    }

    @Override
    public boolean saveProduct(Product product) {
        return productDao.insertSelective(product) > 0;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productDao.updateByPrimaryKey(product) > 0;
    }

    @Override
    public boolean exportExcel(String exportType, Pager pager, Integer[] product_id, Product product, HttpServletResponse response) {
        return false;
    }
}
