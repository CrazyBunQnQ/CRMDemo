package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class CompanyLinkmanWithBLOBs extends CompanyLinkman {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_linkman.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_linkman.share_ids
     *
     * @mbg.generated
     */
    private String shareIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_linkman.remark
     *
     * @param remark the value for c_company_linkman.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_linkman.share_ids
     *
     * @param shareIds the value for c_company_linkman.share_ids
     *
     * @mbg.generated
     */
    public void setShareIds(String shareIds) {
        this.shareIds = shareIds == null ? null : shareIds.trim();
    }
}