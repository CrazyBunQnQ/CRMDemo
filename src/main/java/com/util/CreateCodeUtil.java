package com.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建单号
 *
 * @author CrazyBunQnQ
 * @version 2017/6/29.
 */
public class CreateCodeUtil {
    /**
     * 创建单号code=prefix-time-(num+1) 例：P-20170111-001
     *
     * @param prefix
     * @param num
     *
     * @return
     */
    public static String createCode(String prefix, int num) {
        //1.获得time
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String time = dateFormat.format(new Date());
        //2.获得后缀
        String suffix = "";
        if (num < 1) {
            num = 1;
        } else {
            num = num + 1;
        }
        if (num >= 10 && num <= 99) {
            suffix = "0" + num;
        } else if (num < 10) {
            suffix = "00" + num;
        }
        //拼接并返回
        return prefix + "-" + time + "-" + suffix;
    }

    /**
     * 根据指定日期创建单号code=prefix-time-(num+1) 例：P-20170111-001
     *
     * @param prefix
     * @param date
     * @param num
     *
     * @return
     */
    public static String createCode(String prefix, Date date, int num) {
        //1.获得time
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String time = dateFormat.format(date);
        //2.获得后缀
        String suffix = "";
        if (num < 1) {
            num = 1;
        } else {
            num = num + 1;
        }
        if (num >= 10 && num <= 99) {
            suffix = "0" + num;
        } else if (num < 10) {
            suffix = "00" + num;
        }
        //拼接并返回
        return prefix + "-" + time + "-" + suffix;
    }
}
