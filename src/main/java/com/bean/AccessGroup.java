package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class AccessGroup {
    private Integer id;
    /**
     * 组名
     */
    private String name;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}