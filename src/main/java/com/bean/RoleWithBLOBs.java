package com.bean;

import lombok.Data;

@Data
public class RoleWithBLOBs extends Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_role.popedom
     *
     * @mbg.generated
     */
    private String popedom;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.remark
     *
     * @param remark the value for s_role.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_role.popedom
     *
     * @param popedom the value for s_role.popedom
     *
     * @mbg.generated
     */
    public void setPopedom(String popedom) {
        this.popedom = popedom == null ? null : popedom.trim();
    }
}