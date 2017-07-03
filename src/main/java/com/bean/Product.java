package com.bean;

import lombok.Data;

import java.util.Date;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class Product {
    private Integer id;
    /**
     * 类别 id （关联 productType）
     */
    private Integer ptypeId;
    /**
     * 排序相关（序号）
     */
    private Integer sort;
    /**
     * 创建人
     */
    private String creater;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改人
     */
    private String updater;
    /**
     * 更改时间
     */
    private Date updatetime;
    /**
     * 状态
     */
    private String status;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 型号
     */
    private String model;
    /**
     * 规格
     */
    private String spec;
    /**
     * 单位
     */
    private String unit;
    /**
     * 颜色
     */
    private String color;
    /**
     * 产品尺寸
     */
    private String productSize;
    /**
     * 条码
     */
    private String barCode;
    /**
     * 供应商
     */
    private String provider;
    /**
     * 库存数量
     */
    private Double stock;
    /**
     * 单价
     */
    private Double price;
    /**
     * 采购价
     */
    private Double buyPrice;
    /**
     * 图片路径
     */
    private String picture;
    /**
     * 拼音码
     */
    private String pycode;
    /**
     * 自定义 1
     */
    private String custom1;
    /**
     * 自定义 2
     */
    private String custom2;
    /**
     * 自定义 3
     */
    private String custom3;
    /**
     * 自定义 4
     */
    private String custom4;
    /**
     * 自定选项 1
     */
    private String choice1;
    /**
     * 自定选项 2
     */
    private String choice2;
    /**
     * 自定选项 3
     */
    private String choice3;
    /**
     * 自定选项 4
     */
    private String choice4;
    /**
     * 自定时间 1
     */
    private Date time1;
    /**
     * 自定时间 2
     */
    private Date time2;
    /**
     * 备注
     */
    private String remark;

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize == null ? null : productSize.trim();
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public void setPycode(String pycode) {
        this.pycode = pycode == null ? null : pycode.trim();
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

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}