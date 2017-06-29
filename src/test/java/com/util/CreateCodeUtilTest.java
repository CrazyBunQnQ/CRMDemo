package com.util;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * @version 2017/6/29.
 * @auther CrazyBunQnQ
 */
@Log4j
public class CreateCodeUtilTest {
    @Test
    public void createCode() {
        String code = CreateCodeUtil.createCode("P", 0);
        log.info(code);
    }
}
