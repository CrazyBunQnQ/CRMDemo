package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class CompanyTouch {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.c_id
     *
     * @mbg.generated
     */
    private Integer cId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.link_man
     *
     * @mbg.generated
     */
    private String linkMan;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.link_fashion
     *
     * @mbg.generated
     */
    private String linkFashion;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.link_type
     *
     * @mbg.generated
     */
    private String linkType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.link_time
     *
     * @mbg.generated
     */
    private Date linkTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.next_touch_date
     *
     * @mbg.generated
     */
    private Date nextTouchDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.creater
     *
     * @mbg.generated
     */
    private String creater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.updater
     *
     * @mbg.generated
     */
    private String updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.custom1
     *
     * @mbg.generated
     */
    private String custom1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.custom2
     *
     * @mbg.generated
     */
    private String custom2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.custom3
     *
     * @mbg.generated
     */
    private String custom3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.custom4
     *
     * @mbg.generated
     */
    private String custom4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.choice1
     *
     * @mbg.generated
     */
    private String choice1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.choice2
     *
     * @mbg.generated
     */
    private String choice2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.choice3
     *
     * @mbg.generated
     */
    private String choice3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.choice4
     *
     * @mbg.generated
     */
    private String choice4;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.time1
     *
     * @mbg.generated
     */
    private Date time1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.time2
     *
     * @mbg.generated
     */
    private Date time2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.m_type
     *
     * @mbg.generated
     */
    private String mType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.share_flag
     *
     * @mbg.generated
     */
    private String shareFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c_company_touch.owner_usr
     *
     * @mbg.generated
     */
    private Integer ownerUsr;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.link_man
     *
     * @param linkMan the value for c_company_touch.link_man
     *
     * @mbg.generated
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.link_fashion
     *
     * @param linkFashion the value for c_company_touch.link_fashion
     *
     * @mbg.generated
     */
    public void setLinkFashion(String linkFashion) {
        this.linkFashion = linkFashion == null ? null : linkFashion.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.link_type
     *
     * @param linkType the value for c_company_touch.link_type
     *
     * @mbg.generated
     */
    public void setLinkType(String linkType) {
        this.linkType = linkType == null ? null : linkType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.link_time
     *
     * @param linkTime the value for c_company_touch.link_time
     *
     * @mbg.generated
     */
    public void setLinkTime(Date linkTime) {
        this.linkTime = linkTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.user_name
     *
     * @param userName the value for c_company_touch.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.creater
     *
     * @param creater the value for c_company_touch.creater
     *
     * @mbg.generated
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.updater
     *
     * @param updater the value for c_company_touch.updater
     *
     * @mbg.generated
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.custom1
     *
     * @param custom1 the value for c_company_touch.custom1
     *
     * @mbg.generated
     */
    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.custom2
     *
     * @param custom2 the value for c_company_touch.custom2
     *
     * @mbg.generated
     */
    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.custom3
     *
     * @param custom3 the value for c_company_touch.custom3
     *
     * @mbg.generated
     */
    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.custom4
     *
     * @param custom4 the value for c_company_touch.custom4
     *
     * @mbg.generated
     */
    public void setCustom4(String custom4) {
        this.custom4 = custom4 == null ? null : custom4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.choice1
     *
     * @param choice1 the value for c_company_touch.choice1
     *
     * @mbg.generated
     */
    public void setChoice1(String choice1) {
        this.choice1 = choice1 == null ? null : choice1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.choice2
     *
     * @param choice2 the value for c_company_touch.choice2
     *
     * @mbg.generated
     */
    public void setChoice2(String choice2) {
        this.choice2 = choice2 == null ? null : choice2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.choice3
     *
     * @param choice3 the value for c_company_touch.choice3
     *
     * @mbg.generated
     */
    public void setChoice3(String choice3) {
        this.choice3 = choice3 == null ? null : choice3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.choice4
     *
     * @param choice4 the value for c_company_touch.choice4
     *
     * @mbg.generated
     */
    public void setChoice4(String choice4) {
        this.choice4 = choice4 == null ? null : choice4.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.m_type
     *
     * @param mType the value for c_company_touch.m_type
     *
     * @mbg.generated
     */
    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c_company_touch.share_flag
     *
     * @param shareFlag the value for c_company_touch.share_flag
     *
     * @mbg.generated
     */
    public void setShareFlag(String shareFlag) {
        this.shareFlag = shareFlag == null ? null : shareFlag.trim();
    }
}