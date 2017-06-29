package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class NeedGather {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.sale_id
     *
     * @mbg.generated
     */
    private Integer saleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.pid
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.owner_usr
     *
     * @mbg.generated
     */
    private Integer ownerUsr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.creator
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.createTime
     *
     * @mbg.generated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.updater
     *
     * @mbg.generated
     */
    private String updater;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.updateTime
     *
     * @mbg.generated
     */
    private Date updatetime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.c_id
     *
     * @mbg.generated
     */
    private Integer cId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.c_name
     *
     * @mbg.generated
     */
    private String cName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.c_type
     *
     * @mbg.generated
     */
    private String cType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.build_date
     *
     * @mbg.generated
     */
    private Date buildDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.sale_code
     *
     * @mbg.generated
     */
    private String saleCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.total
     *
     * @mbg.generated
     */
    private Double total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.payed
     *
     * @mbg.generated
     */
    private Double payed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.balance
     *
     * @mbg.generated
     */
    private Double balance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.over_flag
     *
     * @mbg.generated
     */
    private String overFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_need_gather.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.creator
     *
     * @param creator the value for b_need_gather.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.updater
     *
     * @param updater the value for b_need_gather.updater
     *
     * @mbg.generated
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.c_name
     *
     * @param cName the value for b_need_gather.c_name
     *
     * @mbg.generated
     */
    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.c_type
     *
     * @param cType the value for b_need_gather.c_type
     *
     * @mbg.generated
     */
    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.build_date
     *
     * @param buildDate the value for b_need_gather.build_date
     *
     * @mbg.generated
     */
    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.sale_code
     *
     * @param saleCode the value for b_need_gather.sale_code
     *
     * @mbg.generated
     */
    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode == null ? null : saleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.over_flag
     *
     * @param overFlag the value for b_need_gather.over_flag
     *
     * @mbg.generated
     */
    public void setOverFlag(String overFlag) {
        this.overFlag = overFlag == null ? null : overFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_need_gather.status
     *
     * @param status the value for b_need_gather.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}