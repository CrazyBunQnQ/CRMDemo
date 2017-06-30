package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class UserGroup {
    private Integer id;
    private String name;
    private String principal;
    private String incumbent;
    private Integer pid;
    private String fcode;
    private String remark;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public void setIncumbent(String incumbent) {
        this.incumbent = incumbent == null ? null : incumbent.trim();
    }

    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}