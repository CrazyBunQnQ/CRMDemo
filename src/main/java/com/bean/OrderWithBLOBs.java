package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class OrderWithBLOBs extends Order {
    private String remark;
    private String auditReason;
    private String shareIds;

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason == null ? null : auditReason.trim();
    }

    public void setShareIds(String shareIds) {
        this.shareIds = shareIds == null ? null : shareIds.trim();
    }
}