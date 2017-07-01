package com.bean;

import lombok.Data;

/**
 * 操作组权限
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Popedom {
    private Integer id;
    /**
     * 父 id
     */
    private Integer pid;
    /**
     * 编码
     */
    private String code;
    private String name;
    private String istable;
    /**
     * controller 请求的 action 名称（路径）
     */
    private String actionname;
    /**
     * controller 请求的 method 名称
     */
    private String methodname;
    /**
     * 备注
     */
    private String remark;

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setIstable(String istable) {
        this.istable = istable == null ? null : istable.trim();
    }

    public void setActionname(String actionname) {
        this.actionname = actionname == null ? null : actionname.trim();
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname == null ? null : methodname.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}