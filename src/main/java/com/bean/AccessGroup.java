package com.bean;

import lombok.Data;

@Data
public class AccessGroup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_access_group.Id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_access_group.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_access_group.name
     *
     * @param name the value for s_access_group.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}