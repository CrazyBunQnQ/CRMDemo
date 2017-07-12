package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Company {
    private Integer id;
    private String name;
    private String pycode;
    private String code;
    private String grade;
    private String source;
    private String cType;
    private String mType;
    private Integer regionId;
    private String regionName;
    private String province;
    private String city;
    private String fax;
    private String postcode;
    private String tel1;
    private String tel2;
    private String mobile;
    private String email;
    private String web;
    private String address;
    private String dealing;
    private String scale;
    private String registerMoney;
    private String kind;
    private String trade;
    private String legalPerson;
    private String bank;
    private String account;
    private String taxCode;
    private String buyFlag;
    private String creater;
    private Date createTime;
    private String updater;
    private Date updateTime;
    private String status;
    private Date nextTouchDate;
    private Date nextServiceDate;
    private Date firstTouchDate;
    private Date lastTouchDate;
    private String dispensePerson;
    private Date dispenseDate;
    private Integer applyUserId;
    private String sPerson;
    private Date sDate;
    private Date planCallbackDate;
    private String curLinkFlag;
    private String curBuyFlag;
    private Integer freezeLeaveDay;
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Date time1;
    private Date time2;
    private String shareFlag;
    private String quality;
    private Integer ownerUsr;
    private String remark;
    private String nextTouchAim;
    private String sReason;
    private String planCallbackReason;
    private String shareIds;

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setNextTouchAim(String nextTouchAim) {
        this.nextTouchAim = nextTouchAim == null ? null : nextTouchAim.trim();
    }

    public void setsReason(String sReason) {
        this.sReason = sReason == null ? null : sReason.trim();
    }

    public void setPlanCallbackReason(String planCallbackReason) {
        this.planCallbackReason = planCallbackReason == null ? null : planCallbackReason.trim();
    }

    public void setShareIds(String shareIds) {
        this.shareIds = shareIds == null ? null : shareIds.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setPycode(String pycode) {
        this.pycode = pycode == null ? null : pycode.trim();
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public void setcType(String cType) {
        this.cType = cType == null ? null : cType.trim();
    }

    public void setmType(String mType) {
        this.mType = mType == null ? null : mType.trim();
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1 == null ? null : tel1.trim();
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2 == null ? null : tel2.trim();
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public void setWeb(String web) {
        this.web = web == null ? null : web.trim();
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setDealing(String dealing) {
        this.dealing = dealing == null ? null : dealing.trim();
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public void setRegisterMoney(String registerMoney) {
        this.registerMoney = registerMoney == null ? null : registerMoney.trim();
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public void setTrade(String trade) {
        this.trade = trade == null ? null : trade.trim();
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode == null ? null : taxCode.trim();
    }

    public void setBuyFlag(String buyFlag) {
        this.buyFlag = buyFlag == null ? null : buyFlag.trim();
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setNextTouchDate(Date nextTouchDate) {
        this.nextTouchDate = nextTouchDate;
    }

    public void setDispensePerson(String dispensePerson) {
        this.dispensePerson = dispensePerson == null ? null : dispensePerson.trim();
    }

    public void setsPerson(String sPerson) {
        this.sPerson = sPerson == null ? null : sPerson.trim();
    }

    public void setCurLinkFlag(String curLinkFlag) {
        this.curLinkFlag = curLinkFlag == null ? null : curLinkFlag.trim();
    }

    public void setCurBuyFlag(String curBuyFlag) {
        this.curBuyFlag = curBuyFlag == null ? null : curBuyFlag.trim();
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1 == null ? null : custom1.trim();
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2 == null ? null : custom2.trim();
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3 == null ? null : custom3.trim();
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4 == null ? null : custom4.trim();
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1 == null ? null : choice1.trim();
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2 == null ? null : choice2.trim();
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3 == null ? null : choice3.trim();
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4 == null ? null : choice4.trim();
    }

    public void setShareFlag(String shareFlag) {
        this.shareFlag = shareFlag == null ? null : shareFlag.trim();
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }
}