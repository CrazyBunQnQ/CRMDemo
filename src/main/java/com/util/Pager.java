package com.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author CrazyBunQnQ
 * @version 2017/6/29.
 */
@Data
public class Pager implements Serializable {

    /**
     * 封装了分页相关信息
     */
    private static final long serialVersionUID = -6211010175093263237L;
    /**
     * 当前页
     */
    private int page = 1;
    /**
     * 每页显示几条数据
     */
    private int pageSize = 5;
    /**
     * 总记录数
     */
    private int totalRecord;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 从哪条数据开始查询
     */
    private int from = 0;

    public void setPage(int page) {
        this.page = page;
        this.from = (page - 1) * pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.from = (page - 1) * pageSize;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        totalPage = (totalRecord % pageSize == 0) ? (totalRecord / pageSize) : (totalRecord / pageSize + 1);
    }
}
