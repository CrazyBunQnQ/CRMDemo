package com.dao;

import com.bean.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface ProductTypeDao {
    List<ProductType> findProductTypeByPage(@Param("from") int from, @Param("pageSize") int pageSize, @Param("productType") ProductType productType);

    int countProductType(@Param("productType") ProductType productType);

    List<ProductType> findRootProductType();

    List<ProductType> findSubProductType(@Param("pid") Integer pid);

    List<ProductType> listAllProductType();

    List<ProductType> listSelectedProductType(@Param("ids") Integer[] productType_id);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKeyWithBLOBs(ProductType record);

    int updateByPrimaryKey(ProductType record);

    /**
     * 获取子产品类型的数量
     *
     * @param pid
     *
     * @return
     */
    int getSubProductTypeNum(@Param("pid") Integer pid);

    /**
     * 获取指定产品类型下的产品数量
     *
     * @param pid
     *
     * @return
     */
    int getProductNum(@Param("pid") int pid);
}