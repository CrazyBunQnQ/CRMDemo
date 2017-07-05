package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * 应收款项
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class NeedGather {
    private Integer id;
    /**
     * 销售单 id
     */
    private Integer saleId;
    /**
     * 销售收款 id（关联 b_gather）
     */
    private Integer pid;
    /**
     * 所属人
     */
    private Integer ownerUsr;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更改人
     */
    private String updater;
    /**
     * 更改时间
     */
    private Date updatetime;
    /**
     * 客户 id
     */
    private Integer cId;
    /**
     * 客户名称
     */
    private String cName;
    /**
     * 客户类型
     */
    private String cType;
    /**
     * 日期
     */
    private Date buildDate;
    /**
     * 销售单号
     */
    private String saleCode;
    /**
     * 应收金额
     */
    private Double total;
    /**
     * 已收金额
     */
    private Double payed;
    /**
     * 应收余额
     */
    private Double balance;
    /**
     * 是否结束
     */
    private String overFlag;
    /**
     * 状态
     */
    private String status;

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode == null ? null : saleCode.trim();
    }

    public void setOverFlag(String overFlag) {
        this.overFlag = overFlag == null ? null : overFlag.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}