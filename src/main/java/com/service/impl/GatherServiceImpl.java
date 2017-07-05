package com.service.impl;

import com.dao.GatherDao;
import com.service.GatherService;
import lombok.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 2017/7/6.
 * @auther CrazyBunQnQ
 */
@Log4j
@Service
public class GatherServiceImpl implements GatherService {
    @Autowired
    private GatherDao gatherDao;
}
