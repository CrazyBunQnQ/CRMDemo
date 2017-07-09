package com.bean;

import lombok.Data;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Data
public class NeedGatherWithBLOBs extends NeedGather {
    /**
     * 共享 id
     */
    private String shareid;
    /**
     * （读）共享 id
     */
    private String readShareid;
    /**
     * 备注
     */
    private String remark;

    public void setShareid(String shareid) {
        this.shareid = shareid == null ? null : shareid.trim();
    }

    public void setReadShareid(String readShareid) {
        this.readShareid = readShareid == null ? null : readShareid.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}