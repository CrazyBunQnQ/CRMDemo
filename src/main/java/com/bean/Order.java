package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * 销售单
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Order {
    private Integer id;
    /**
     * 所属人
     */
    private Integer ownerUsr;
    /**
     * 创建人
     */
    private String creater;
    /**创建时间
     *
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
     * 编码
     */
    private String code;
    /**
     * 开单日期
     */
    private Date orderDate;
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
     * 联系人
     */
    private String linkman;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 送货地址
     */
    private String address;
    /**
     * 卖方业务员
     */
    private String seller;
    /**
     * 金额
     */
    private Double total;
    /**
     * 折扣
     */
    private Double agio;
    /**
     * 总折扣
     */
    private Double agioTotal;
    /**
     * 审计员
     */
    private String auditor;
    /**
     * 审计日期
     */
    private Date auditDate;
    /**
     * 状态 id
     */
    private String statusId;
    /**
     * 状态
     */
    private String status;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Date time1;
    private Date time2;
    private String shareFlag;

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setCName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId == null ? null : statusId.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4 == null ? null : custom4.trim();
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1 == null ? null : choice1.trim();
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2 == null ? null : choice2.trim();
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3 == null ? null : choice3.trim();
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4 == null ? null : choice4.trim();
    }

    public void setShareFlag(String shareFlag) {
        this.shareFlag = shareFlag == null ? null : shareFlag.trim();
    }
}