package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class GatherWithBLOBs extends Gather {
    /**
     * 备注
     */
    private String remark;
    /**
     * 审计意见
     */
    private String auditIdea;

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setAuditIdea(String auditIdea) {
        this.auditIdea = auditIdea == null ? null : auditIdea.trim();
    }
}