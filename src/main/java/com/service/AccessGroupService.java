package com.service;

import com.bean.AccessGroupWithBLOBs;

import java.util.List;

/**
 * @version 2017/7/10.
 * @auther CrazyBunQnQ
 */
public interface AccessGroupService extends BaseService<AccessGroupWithBLOBs> {
    List<AccessGroupWithBLOBs> listAll();
}
