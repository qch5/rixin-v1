package com.rixin.base.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * User: dairan
 * Date: 2015-12-18 17:24
 */
public class DateFormatUtils extends org.apache.commons.lang.time.DateFormatUtils {
    public static final String DATE_FORMAT_DEFAULT;
    public static final String DATE_FORMAT_YEAR = "yyyy";
    public static final String DATE_FORMAT_MONTH = "yyyy-MM";
    public static final String DATE_FORMAT_DATE = "yyyy-MM-dd";
    public static final String DATE_FORMAT_DATETIME_MINUTE = "yyyy-MM-dd HH:mm";
    public static final String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_CST = "EEE MMM dd HH:mm:ss 'CST' yyyy";

    static {
        DATE_FORMAT_DEFAULT = DATE_FORMAT_DATETIME;
    }

    public static String format(Date date) {
        if(date==null) {
            return null;
        }
        String s = org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
        if(s==null) {
            return org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return s;
    }

    public static final Date parseDate(String strDate) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(DATE_FORMAT_DEFAULT);

        try {
            date = df.parse(strDate);
        } catch (ParseException e) {}

        return (date);
    }

    public static final Date parseDate(String strDate, String format) {
        SimpleDateFormat df = null;
        Date date = null;
        if(!StringUtils.isBlank(format) && format.equals(DATE_FORMAT_CST)) {
            df = new SimpleDateFormat(DATE_FORMAT_CST, Locale.US);
        } else {
            df = new SimpleDateFormat(format);
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return (date);
    }

    public static Date formatDate(Date date,String format) {
        SimpleDateFormat inDf = new SimpleDateFormat(format);
        SimpleDateFormat outDf = new SimpleDateFormat(format);
        String reDate = "";
        try {
            reDate = inDf.format(date);
            return outDf.parse(reDate);
        } catch (Exception e) {

        }
        return date;
    }

    /**
     * 获取当天零点时间
     */
    public static String formatZeroTime() {
        return formatZeroTime(0);
    }
    public static String formatZeroTime(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Long startTime = cal.getTimeInMillis();
        return org.apache.commons.lang.time.DateFormatUtils.format(startTime, DATE_FORMAT_DATETIME);
    }

    /**
     * 获取指定时间毫秒数
     */
    public static Long formatMilli(String date) {
        if(StringUtils.isBlank(date)) {
            return formatMilli(new Date());
        }
        return parseDate(date).getTime() / 1000;
    }
    public static Long formatMilli(Date date) {
        return date.getTime() / 1000;
    }
    public static Long formatMilli(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + day);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis() / 1000;
    }
    
    public static Date addMinutes(Date date, Integer minutes) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MINUTE, minutes);
        Date dt1 = rightNow.getTime();
        return dt1;
    }
}
