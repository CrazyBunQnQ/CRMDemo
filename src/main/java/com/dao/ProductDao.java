package com.dao;

import com.bean.Product;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface ProductDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int insert(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int insertSelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Product record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table b_product
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Product record);
}