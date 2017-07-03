package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class User {
    private Integer id;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改人
     */
    private String updater;
    /**
     * 修改时间
     */
    private Date updatetime;
    /**
     * 用户名
     */
    private String name;
    /**
     * 中文名
     */
    private String cnname;
    /**
     * 密码
     */
    private String password;
    /**
     * 家庭地址
     */
    private String address;
    /**
     * 家庭电话
     */
    private String telephone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 起始有效期
     */
    private Date begindate;
    /**
     * 终止有效期
     */
    private Date enddate;
    /**
     * 查询文件级别
     */
    private String accessFilelevel;
    /**
     * 状态："启用"，"停用"
     */
    private String status;
    /**
     * 推荐人
     */
    private String commendman;
    /**
     * 移动电话
     */
    private String movetelephone;
    /**
     * 现住址
     */
    private String nowaddress;
    /**
     * 现住址电话
     */
    private String nowtelephone;
    /**
     * 身份证号
     */
    private String identitycode;
    /**
     * 社会保险号
     */
    private String insurancecode;
    /**
     * 紧急联系人
     */
    private String instancylinkman;
    /**
     * 紧急联系电话
     */
    private String instancytelephone;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 职员类别："全职"，"兼职"
     */
    private String personneltype;
    /**
     * 职务
     */
    private String duty;
    /**
     * 入职时间
     */
    private Date workdate;
    /**
     * 最高学历
     */
    private String highschool;
    /**
     * 毕业学校
     */
    private String finishschool;
    /**
     * 毕业时间
     */
    private Date finishschooldate;
    /**
     * 配偶姓名
     */
    private String consortname;
    /**
     * 子女姓名
     */
    private String youngonename;
    /**
     * 办公电话
     */
    private String officetelephone;
    /**
     * 配偶电话
     */
    private String consorttelephone;
    /**
     * 配偶工作单位
     */
    private String consortcompany;
    /**
     * 角色 id
     */
    private Integer roleId;
    /**
     * 用户组 id（部门 id）
     */
    private Integer groupId;
    /**
     * 查询权限组 id
     */
    private Integer accessGroupId;

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public void setAccessFilelevel(String accessFilelevel) {
        this.accessFilelevel = accessFilelevel == null ? null : accessFilelevel.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setCommendman(String commendman) {
        this.commendman = commendman == null ? null : commendman.trim();
    }

    public void setMovetelephone(String movetelephone) {
        this.movetelephone = movetelephone == null ? null : movetelephone.trim();
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress == null ? null : nowaddress.trim();
    }

    public void setNowtelephone(String nowtelephone) {
        this.nowtelephone = nowtelephone == null ? null : nowtelephone.trim();
    }

    public void setIdentitycode(String identitycode) {
        this.identitycode = identitycode == null ? null : identitycode.trim();
    }

    public void setInsurancecode(String insurancecode) {
        this.insurancecode = insurancecode == null ? null : insurancecode.trim();
    }

    public void setInstancylinkman(String instancylinkman) {
        this.instancylinkman = instancylinkman == null ? null : instancylinkman.trim();
    }

    public void setInstancytelephone(String instancytelephone) {
        this.instancytelephone = instancytelephone == null ? null : instancytelephone.trim();
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public void setPersonneltype(String personneltype) {
        this.personneltype = personneltype == null ? null : personneltype.trim();
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public void setHighschool(String highschool) {
        this.highschool = highschool == null ? null : highschool.trim();
    }

    public void setFinishschool(String finishschool) {
        this.finishschool = finishschool == null ? null : finishschool.trim();
    }

    public void setConsortname(String consortname) {
        this.consortname = consortname == null ? null : consortname.trim();
    }

    public void setYoungonename(String youngonename) {
        this.youngonename = youngonename == null ? null : youngonename.trim();
    }

    public void setOfficetelephone(String officetelephone) {
        this.officetelephone = officetelephone == null ? null : officetelephone.trim();
    }

    public void setConsorttelephone(String consorttelephone) {
        this.consorttelephone = consorttelephone == null ? null : consorttelephone.trim();
    }

    public void setConsortcompany(String consortcompany) {
        this.consortcompany = consortcompany == null ? null : consortcompany.trim();
    }
}