package com.dao;

import com.bean.CompanyLinkman;
import com.bean.CompanyLinkmanWithBLOBs;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface CompanyLinkmanDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int insert(CompanyLinkmanWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int insertSelective(CompanyLinkmanWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    CompanyLinkmanWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CompanyLinkmanWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(CompanyLinkmanWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table c_company_linkman
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CompanyLinkman record);
}