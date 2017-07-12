package com.bean;

import lombok.Data;

/**
 * 销售单明细
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class OrderDetail extends BaseBean {
    private Integer id;
    /**
     * 产品名称
     */
    private String pName;
    /**
     * 规格
     */
    private String spec;
    /**
     * 单位
     */
    private String unit;
    /**
     * 数量
     */
    private Double amount;
    /**
     * 单价
     */
    private Double price;
    /**
     * 折扣
     */
    private Double agio;
    /**
     * 金额
     */
    private Double total;
    /**
     * 备注
     */
    private String remark;
    /**
     * 销售单 id
     */
    private Integer orderId;
    /**
     * 商品 id
     */
    private Integer pId;

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}