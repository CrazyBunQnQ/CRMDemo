package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class CompanyTouchWithBLOBs extends CompanyTouch {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.content
     *
     * @mbg.generated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.next_touch_aim
     *
     * @mbg.generated
     */
    private String nextTouchAim;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.share_ids
     *
     * @mbg.generated
     */
    private String shareIds;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.content
     *
     * @param content the value for c_company_touch.content
     *
     * @mbg.generated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.next_touch_aim
     *
     * @param nextTouchAim the value for c_company_touch.next_touch_aim
     *
     * @mbg.generated
     */
    public void setNextTouchAim(String nextTouchAim) {
        this.nextTouchAim = nextTouchAim == null ? null : nextTouchAim.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.remark
     *
     * @param remark the value for c_company_touch.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.share_ids
     *
     * @param shareIds the value for c_company_touch.share_ids
     *
     * @mbg.generated
     */
    public void setShareIds(String shareIds) {
        this.shareIds = shareIds == null ? null : shareIds.trim();
    }
}