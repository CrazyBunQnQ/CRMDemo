package com.dao;

import com.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface ProductDao extends BaseDao<Product> {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> listProductByPage(@Param("from") int from, @Param("pageSize") int pageSize, @Param("product") Product product);

    int countProduct(@Param("product") Product product);

    int removeByPrimaryKeys(@Param("ids") Integer[] ids);

    List<Product> listAllProduct();

    List<Product> listSelectedProduct(@Param("ids") Integer[] ids);

    List<Product> findProductByName(@Param("pName") String pName);
}