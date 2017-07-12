package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class AccessGroup extends BaseBean {
    private Integer id;
    /**
     * 组名
     */
    private String name;
    /**
     * 部门 id（用户组 id）拼成的字符串，例："1,2,3,4"
     */
    private String dpte;
    /**
     * 备注
     */
    private String remark;

    public void setDpte(String dpte) {
        this.dpte = dpte == null ? null : dpte.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}