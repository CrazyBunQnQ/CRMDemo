package com.util;

import lombok.extern.log4j.Log4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @version 2017/7/8.
 * @auther CrazyBunQnQ
 */
@Log4j
public class StringUtil {
    public static String decode(String str, String enc) {
        if (str.contains("%")) {
            try {
                str = URLDecoder.decode(str, enc);
            } catch (UnsupportedEncodingException e) {
                log.error("解码错误");
                e.printStackTrace();
            }
        }
        return str;
    }
}
