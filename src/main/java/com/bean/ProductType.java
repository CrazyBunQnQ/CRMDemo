package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class ProductType {
    private Integer id;
    /**
     * 父级 id
     */
    private Integer pid;
    private String fcode;
    /**
     * 编码
     */
    private String code;
    private String name;
    private Integer sort;
    private Date createTime;
    /**
     * 备注
     */
    private String remark;
    private String fatherName;

    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}