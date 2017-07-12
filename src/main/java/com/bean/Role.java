package com.bean;

import lombok.Data;

/**
 * 角色（操作权限）
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Role extends BaseBean {
    private Integer id;
    private String name;
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

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}