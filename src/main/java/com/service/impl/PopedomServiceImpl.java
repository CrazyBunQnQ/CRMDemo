package com.service.impl;

import com.bean.Popedom;
import com.dao.PopedomDao;
import com.dao.RoleDao;
import com.service.PopedomService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 2017/7/1.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class PopedomServiceImpl implements PopedomService {
    @Autowired
    private PopedomDao popedomDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public String getTree() {
        List<Popedom> rootList = popedomDao.listRootPopedom();
        StringBuffer selectOptionStr = new StringBuffer("<ul class='simpleTree'><li class='root'><span>根节点</span><ul>");
        if (rootList != null && rootList.size() > 0) {
            for (Popedom p : rootList) {
                selectOptionStr.append("<li id='" + p.getId() + "'><span>" + p.getName() + "</span>");
                selectOptionStr.append(getSubTree(p.getId()));
                selectOptionStr.append("</li>");
            }
        }
        return selectOptionStr.append("</ul></li></ul>").toString();
    }

    /**
     * 获取子权限字符串
     *
     * @param pid
     *
     * @return
     */
    private String getSubTree(int pid) {
        List<Popedom> subList = popedomDao.listSubPopedom(pid);
        if (subList == null || subList.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer("<ul>");
        for (Popedom p : subList) {
            sb.append("<li id='" + p.getId() + "'><span>" + p.getName() + "</span>");
            sb.append(getSubTree(p.getId()));
            sb.append("</li>");
        }
        return sb.append("</ul>").toString();
    }

    @Override
    public List<Popedom> listPopedom() {
        List<Popedom> list = new ArrayList<Popedom>();
        return list;
    }

    public List<Popedom> listPopedomByRole() {
//        List<Popedom> baseList = popedomDao.listPopedomByRole();
        return null;
    }

    @Override
    public String getPopedomByRoleId(Integer id) {
        return roleDao.selectByPrimaryKey(id).getPopedom();
    }

    /*function selectModel(code) {
        var objs = document.getElementsByTagName("input");
        if (code.indexOf("_") == -1) {
            for (var i = 0; i < objs.length; i++) {
                if (objs[i].id.indexOf("_") != -1) {
                    var s = objs[i].id.substring(0, objs[i].id.indexOf("_"));
                    if (code == s) {
                        var o = document.getElementById(code + "pop");
                        objs[i].checked = o.checked;
                    }
                }

            }
        } else {
            selectSubModel(code);
        }
    }*/
    /*function selectSubModel(code) {
        var objs = document.getElementsByTagName("input");
        for (var i = 0; i < objs.length; i++) {
            if (objs[i].id.lastIndexOf("_") != -1) {
                var s = objs[i].id.substring(0, objs[i].id.lastIndexOf("_"));
                if (s.indexOf("_") != -1) {
                    s = objs[i].id.substring(0, objs[i].id.lastIndexOf("_"));
                    if (code == s) {
                        var o = document.getElementById(code + "pop");
                        objs[i].checked = o.checked;
                    }
                }
            }
        }
    }*/

    @Override
    public String getDrag(Integer role_id, Integer id, boolean enable) {
        List<Popedom> list = popedomDao.listSubPopedom(id == null ? Integer.valueOf(0) : Integer.valueOf(id));
        String[] all = roleDao.getPopedomByRole(role_id).split(",");
        List<Integer> allId = new ArrayList<Integer>();
        for (int i = 0; i < all.length; i ++) {
            allId.add(Integer.valueOf(all[i]));
        }
        StringBuffer checkedOptionStr = new StringBuffer("<ul>");
        if (list != null && list.size() > 0) {
            for (Popedom p : list) {
                checkedOptionStr.append("<li id><span>");
                if (enable) {
//                    checkedOptionStr.append("<input type='checkbox' id='" + p.getCode() + "_" + p.getId() + "'>" + p.getName() + "</span>");
                    checkedOptionStr.append("<input type='checkbox' name='popedomValue' value='" + p.getId());
                    if (allId.contains(p.getId())) {
                        checkedOptionStr.append("' checked='checked'>" + p.getName() + "</span>");
                    } else {
                        checkedOptionStr.append("'>" + p.getName() + "</span>");
                    }
                } else {
                    checkedOptionStr.append(p.getName() + "</span>");
                }
                checkedOptionStr.append(getDrag(role_id, p.getId(), false));
                checkedOptionStr.append("</li>");
            }
        }
        return checkedOptionStr.append("</ul>").toString();
    }
}
