package com.service;

import com.bean.AccessGroup;

import java.util.List;

/**
 * @version 2017/7/10.
 * @auther CrazyBunQnQ
 */
public interface AccessGroupService extends BaseService<AccessGroup> {
    List<AccessGroup> listAll();
}
