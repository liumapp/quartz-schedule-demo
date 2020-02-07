package com.liumapp.schedule.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class TimeUtils {
    /**
     * 计算两个时间差多少秒
     * @param startDate
     * @return
     */
    public static int getTimeSecond (Date startDate) {
        long a = new Date().getTime();
        long b = startDate.getTime();
        int c = (int)((b - a) / 1000);
        return c;
    }

    /**
     *
     * @param dateFormat yyyy-mm-dd HH:ii:ss
     * @return
     */
    public static long fromDateToMilSec (String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
