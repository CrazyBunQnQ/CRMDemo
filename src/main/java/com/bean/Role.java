package com.bean;

import lombok.Data;

/**
 * 角色（操作权限）
 *
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Role {
    private Integer id;
    private String name;

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}