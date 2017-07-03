package com.service.impl;

import com.bean.Popedom;
import com.dao.PopedomDao;
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
        if (subList == null && subList.size() == 0) {
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
}
