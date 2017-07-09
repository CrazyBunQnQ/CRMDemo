package com.bean;

import com.util.DateUtils;
import com.util.StringUtil;
import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class User extends BaseBean {
    private Integer id;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createtime;
    private String createtimeStr;
    /**
     * 修改人
     */
    private String updater;
    /**
     * 修改时间
     */
    private Date updatetime;
    private String updatetimeStr;
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
    private String begindateStr;
    /**
     * 终止有效期
     */
    private Date enddate;
    private String enddateStr;
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
    private String birthdayStr;
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
    private String workdateStr;
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
    private String finishschooldateStr;
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
    private String roleName;
    /**
     * 用户组 id（部门 id）
     */
    private Integer groupId;
    private String groupName;
    /**
     * 查询权限组 id
     */
    private Integer accessGroupId;
    private String accessGroupName;
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

    public String getCreatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", createtime);
    }

    public void setCreatetimeStr(String createtimeStr) {
        this.createtime = DateUtils.strToDate("yyyy-MM-dd", createtimeStr);
        this.createtimeStr = createtimeStr;
    }

    public String getUpdatetimeStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", updatetime);
    }

    public void setUpdatetimeStr(String updatetimeStr) {
        this.updatetime = DateUtils.strToDate("yyyy-MM-dd", updatetimeStr);
        this.updatetimeStr = updatetimeStr;
    }

    public String getEnddateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", enddate);
    }

    public void setEnddateStr(String enddateStr) {
        this.enddate = DateUtils.strToDate("yyyy-MM-dd", enddateStr);
        this.enddateStr = enddateStr;
    }

    public String getBegindateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", begindate);
    }

    public void setBegindateStr(String begindateStr) {
        this.begindate = DateUtils.strToDate("yyyy-MM-dd", begindateStr);
        this.begindateStr = begindateStr;
    }

    public String getBirthdayStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", birthday);
    }

    public void setBirthdayStr(String createtimeStr) {
        this.birthday = DateUtils.strToDate("yyyy-MM-dd", birthdayStr);
        this.birthdayStr = birthdayStr;
    }

    public String getWorkdateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", workdate);
    }

    public void setWorkdateStr(String workdateStr) {
        this.workdate = DateUtils.strToDate("yyyy-MM-dd", workdateStr);
        this.workdateStr = workdateStr;
    }

    public String getFinishschooldateStr() {
        return DateUtils.dateToStr("yyyy-MM-dd", finishschooldate);
    }

    public void setFinishschooldateStr(String finishschooldateStr) {
        this.finishschooldate = DateUtils.strToDate("yyyy-MM-dd", finishschooldateStr);
        this.finishschooldateStr = finishschooldateStr;
    }

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
        status = StringUtil.decode(status, "utf-8");
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