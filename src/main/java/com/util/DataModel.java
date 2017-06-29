package com.util;

import lombok.Data;

import java.util.List;

/**
 * 封装了 分页对象 以及数据集合
 *
 * @param <T>
 *
 * @author CrazyBunQnQ
 * @version 2017/6/29.
 */
@Data
public class DataModel<T> {

    private Pager pager;
    /**
     * 结果集
     */
    private List<T> rows;
}
