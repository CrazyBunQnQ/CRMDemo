package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * 销售收款
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Gather extends BaseBean{
    private Integer id;
    /**
     * 所属人
     */
    private Integer ownerUsr;
    /**
     * 创建人
     */
    private String creater;
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
     * 支付人
     */
    private String payer;
    /**
     * 支付时间
     */
    private Date payDate;
    /**
     * 支付类型
     */
    private String payType;
    /**
     * 账单号
     */
    private String billCode;
    /**
     * 操作人
     */
    private String handler;
    /**
     * 总金额
     */
    private Double total;
    /**
     * 状态 id
     */
    private String statusId;
    /**
     * 状态
     */
    private String status;
    /**
     * 审计员
     */
    private String auditor;
    /**
     * 审计日期
     */
    private Date auditDate;
    /**
     * 编码
     */
    private String code;

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
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

    public void setPayer(String payer) {
        this.payer = payer == null ? null : payer.trim();
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    public void setHandler(String handler) {
        this.handler = handler == null ? null : handler.trim();
    }

    public void setStatusid(String statusid) {
        this.statusId = statusid == null ? null : statusId.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}