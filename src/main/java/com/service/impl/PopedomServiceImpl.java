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
    public List<Popedom> listPopedom() {
        List<Popedom> list = new ArrayList<Popedom>();
        return list;
    }
}
