package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class RoleWithBLOBs extends Role {
    /**
     * 备注
     */
    private String remark;
    /**
     * 权限
     */
    private String popedom;

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setPopedom(String popedom) {
        this.popedom = popedom == null ? null : popedom.trim();
    }
}