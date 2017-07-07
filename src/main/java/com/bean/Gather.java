package com.bean;

import com.util.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * 销售收款
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Gather extends BaseBean {
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
    private String createtimeStr;
    /**
     * 更改人
     */
    private String updater;
    /**
     * 更改时间
     */
    private Date updatetime;
    private String updatetimeStr;
    /**
     * 客户 id
     */
    private Integer cusId;
    /**
     * 客户名称
     */
    private String cusName;
    /**
     * 客户类型
     */
    private String cusType;
    /**
     * 支付人
     */
    private String payer;
    /**
     * 支付时间
     */
    private Date payDate;
    private String payDateStr;
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
    private String auditDateStr;
    /**
     * 编码
     */
    private String code;

    public void setCreatetimeStr(String createtimeStr) {
        this.createtime = DateUtils.strToDate("yyyy-MM-dd", createtimeStr);
        this.createtimeStr = createtimeStr;
    }

    public String getCreatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", createtime);
    }

    public void setUpdatetimeStr(String updatetimeStr) {
        this.updatetime = DateUtils.strToDate("yyyy-MM-dd", updatetimeStr);
        this.updatetimeStr = updatetimeStr;
    }

    public String getUpdatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", updatetime);
    }

    public void setPayDateStr(String payDateStr) {
        this.payDate = DateUtils.strToDate("yyyy-MM-dd", payDateStr);
        this.payDateStr = payDateStr;
    }

    public String getPayDateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", payDate);
    }

    public String getAuditDatetr() {
        return DateUtils.dateToStr("yyyy-MM-dd", createtime);
    }

    public void setAuditDateStr(String auditDateStr) {
        this.auditDate = DateUtils.strToDate("yyyy-MM-dd", auditDateStr);
        this.auditDateStr = auditDateStr;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setCusName(String cusName) {
        this.cusName = cusName == null ? null : cusName.trim();
    }

    public void setCusType(String cusType) {
        this.cusType = cusType == null ? null : cusType.trim();
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