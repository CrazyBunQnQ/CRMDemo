package com.bean;

import com.util.DateUtils;
import com.util.StringUtil;
import lombok.Data;

import java.util.Date;

/**
 * 应收款项
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class NeedGather extends BaseBean {
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
     * 所属人 id
     */
    private Integer ownerUsr;
    private String ownerUsrName;
    /**
     * 创建人
     */
    private String creator;
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
     * 日期
     */
    private Date buildDate;
    private String buildDateStr;
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
    /**
     * 共享 id
     */
    private String shareid;
    /**
     * （读）共享 id
     */
    private String readShareid;
    /**
     * 备注
     */
    private String remark;
    /**
     * 省份
     */
    private String province;
    private String city;
    /**
     * 区域
     */
    private String regionName;

    public String getCreatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", createtime);
    }

    public void setCreatetimeStr(String createtimeStr) {
        this.createtime = DateUtils.strToDate("yyyy-MM-dd", createtimeStr);
        this.createtimeStr = createtimeStr;
    }

    public Date getCreatetime() {
        this.createtimeStr = DateUtils.dateToStr("yyyy-MM-dd", createtime);
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtimeStr = DateUtils.dateToStr("yyyy-MM-dd", createtime);
        this.createtime = createtime;
    }

    public String getUpdatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", updatetime);
    }

    public void setUpdatetimeStr(String updatetimeStr) {
        this.updatetime = DateUtils.strToDate("yyyy-MM-dd", updatetimeStr);
        this.updatetimeStr = updatetimeStr;
    }

    public Date getUpdatetime() {
        this.updatetimeStr = DateUtils.dateToStr("yyyy-MM-dd", updatetime);
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetimeStr = DateUtils.dateToStr("yyyy-MM-dd", updatetime);
        this.updatetime = updatetime;
    }

    public String getBuildDateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", buildDate);
    }

    public void setBuildDateStr(String buildDateStr) {
        this.buildDate = DateUtils.strToDate("yyyy-MM-dd", buildDateStr);
        this.buildDateStr = buildDateStr;
    }

    public Date getBuildDate() {
        this.buildDateStr = DateUtils.dateToStr("yyyy-MM-dd", buildDate);
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDateStr = DateUtils.dateToStr("yyyy-MM-dd", buildDate);
        this.buildDate = buildDate;
    }

    public void setShareid(String shareid) {
        this.shareid = shareid == null ? null : shareid.trim();
    }

    public void setReadShareid(String readShareid) {
        this.readShareid = readShareid == null ? null : readShareid.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode == null ? null : saleCode.trim();
    }

    public void setOverFlag(String overFlag) {
        this.overFlag = overFlag == null ? null : overFlag.trim();
    }

    public void setStatus(String status) {
        status = StringUtil.decode(status, "utf-8");
        this.status = status == null ? null : status.trim();
    }
}