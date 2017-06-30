package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class UserWithBLOBs extends User {
    /**
     * 备注
     */
    private String remark;
    /**
     * 菜单
     */
    private String menus;
    /**
     * 权限
     */
    private String popedom;
    /**
     * 业余爱好
     */
    private String avocation;
    /**
     * 偏好特长
     */
    private String strongsuit;
    /**
     * 信息沟通
     */
    private String communicate;
    /**
     * 培训情况
     */
    private String bringup;
    /**
     * 组织能力
     */
    private String organise;
    /**
     * 分析能力
     */
    private String analyse;
    /**
     * 计划能力
     */
    private String planing;
    /**
     * 人员开发
     */
    private String empolder;
    /**
     * 人际关系
     */
    private String relation;

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setMenus(String menus) {
        this.menus = menus == null ? null : menus.trim();
    }

    public void setPopedom(String popedom) {
        this.popedom = popedom == null ? null : popedom.trim();
    }

    public void setAvocation(String avocation) {
        this.avocation = avocation == null ? null : avocation.trim();
    }

    public void setStrongsuit(String strongsuit) {
        this.strongsuit = strongsuit == null ? null : strongsuit.trim();
    }

    public void setCommunicate(String communicate) {
        this.communicate = communicate == null ? null : communicate.trim();
    }

    public void setBringup(String bringup) {
        this.bringup = bringup == null ? null : bringup.trim();
    }

    public void setOrganise(String organise) {
        this.organise = organise == null ? null : organise.trim();
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse == null ? null : analyse.trim();
    }

    public void setPlaning(String planing) {
        this.planing = planing == null ? null : planing.trim();
    }

    public void setEmpolder(String empolder) {
        this.empolder = empolder == null ? null : empolder.trim();
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}