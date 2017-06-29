package com.bean;

import lombok.Data;

@Data
public class OrderDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.p_name
     *
     * @mbg.generated
     */
    private String pName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.spec
     *
     * @mbg.generated
     */
    private String spec;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.unit
     *
     * @mbg.generated
     */
    private String unit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.amount
     *
     * @mbg.generated
     */
    private Double amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.agio
     *
     * @mbg.generated
     */
    private Double agio;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.total
     *
     * @mbg.generated
     */
    private Double total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.order_id
     *
     * @mbg.generated
     */
    private Integer orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column b_order_detail.p_id
     *
     * @mbg.generated
     */
    private Integer pId;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_detail.p_name
     *
     * @param pName the value for b_order_detail.p_name
     *
     * @mbg.generated
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_detail.spec
     *
     * @param spec the value for b_order_detail.spec
     *
     * @mbg.generated
     */
    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_detail.unit
     *
     * @param unit the value for b_order_detail.unit
     *
     * @mbg.generated
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column b_order_detail.remark
     *
     * @param remark the value for b_order_detail.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}