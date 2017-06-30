package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class UserWithBLOBs extends User {
    private String remark;
    private String menus;
    private String popedom;
    private String avocation;
    private String strongsuit;
    private String communicate;
    private String bringup;
    private String organise;
    private String analyse;
    private String planing;
    private String empolder;
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