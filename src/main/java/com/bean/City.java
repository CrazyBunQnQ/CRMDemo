package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class City {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.pid
     *
     * @mbg.generated
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.pycode
     *
     * @mbg.generated
     */
    private String pycode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.postcode
     *
     * @mbg.generated
     */
    private String postcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_city.areacode
     *
     * @mbg.generated
     */
    private String areacode;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_city.name
     *
     * @param name the value for s_city.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_city.pycode
     *
     * @param pycode the value for s_city.pycode
     *
     * @mbg.generated
     */
    public void setPycode(String pycode) {
        this.pycode = pycode == null ? null : pycode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_city.postcode
     *
     * @param postcode the value for s_city.postcode
     *
     * @mbg.generated
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_city.areacode
     *
     * @param areacode the value for s_city.areacode
     *
     * @mbg.generated
     */
    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }
}