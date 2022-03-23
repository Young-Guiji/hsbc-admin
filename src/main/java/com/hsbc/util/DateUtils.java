package com.hsbc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static String fullPattern = "yyyy-MM-dd HH:mm:ss";

    /**
     *
     * @return
     *  yyyy-MM-dd HH:mm:ss
     *  2022-03-21 23:47:36
     */
    public static String getFullDate(Date date) {
        SimpleDateFormat simple = new SimpleDateFormat(fullPattern);
        return simple.format(date);
    }

    /**
     *
     * @return
     *  yyyy-MM-dd HH:mm:ss
     *  2022-03-21 23:47:36
     */
    public static Date parseFullDate(String date) throws ParseException {
        SimpleDateFormat simple = new SimpleDateFormat(fullPattern);
        return simple.parse(date);
    }
}
