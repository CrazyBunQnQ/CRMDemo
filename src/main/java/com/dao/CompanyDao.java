package com.dao;

import com.bean.Company;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
public interface CompanyDao extends BaseDao<Company> {
    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKeyWithBLOBs(Company record);

    int updateByPrimaryKey(Company record);

}