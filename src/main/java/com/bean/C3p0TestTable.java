package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class C3p0TestTable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column c3p0testtable.a
     *
     * @mbg.generated
     */
    private String a;

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column c3p0testtable.a
     *
     * @param a the value for c3p0testtable.a
     *
     * @mbg.generated
     */
    public void setA(String a) {
        this.a = a == null ? null : a.trim();
    }
}