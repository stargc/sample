package com.ehl.tsq.data.infrastructure.util;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author created by guanchen on 2019/12/21 16:50
 */
public class EHLDateUtil {


    public static Date getTodayStart(Date date){
        return getDayStart(new Date());
    }
    public static Date getDayStart(Date date){
        Calendar dayStart = Calendar.getInstance();
        if (date != null){
            dayStart.setTime(date);
        }
        dayStart.set(Calendar.HOUR_OF_DAY,0);
        dayStart.set(Calendar.MINUTE,0);
        dayStart.set(Calendar.SECOND,0);
        return dayStart.getTime();
    }

    public static Date getTodayEnd(Date date){
        return getDayEnd(new Date());
    }
    public static Date getDayEnd(Date date){
        Calendar dayEnd = Calendar.getInstance();
        if (date != null){
            dayEnd.setTime(date);
        }
        dayEnd.set(Calendar.HOUR_OF_DAY,23);
        dayEnd.set(Calendar.MINUTE,59);
        dayEnd.set(Calendar.SECOND,59);
        return dayEnd.getTime();
    }

    public static Date getNowYearStart(){
        Calendar now = Calendar.getInstance();
        return getYearStart(now.get(Calendar.YEAR));
    }
    public static Date getYearStart(int year){
        Calendar yearStart = Calendar.getInstance();
        yearStart.clear();
        yearStart.set(Calendar.YEAR,year);
        return yearStart.getTime();
    }

    public static Date getNowYearEnd(){
        Calendar now = Calendar.getInstance();
        return getYearEnd(now.get(Calendar.YEAR));
    }
    public static Date getYearEnd(int year){
        Calendar yearEnd = Calendar.getInstance();
        yearEnd.clear();
        yearEnd.set(Calendar.YEAR, year + 1);
        return DateUtils.addSeconds(yearEnd.getTime(), -1);
    }

    public static Date getNowMonthStart(){
        Calendar now = Calendar.getInstance();
        return getMonthStart(now.get(Calendar.YEAR),now.get(Calendar.MONTH) + 1);
    }

    public static Date getNowMonthEnd(){
        Calendar now = Calendar.getInstance();
        return getMonthEnd(now.get(Calendar.YEAR),now.get(Calendar.MONTH) + 1);
    }

    public static Date getMonthStart(int year,int month){
        Calendar monthStart = Calendar.getInstance();
        monthStart.clear();
        monthStart.set(Calendar.YEAR, year);
        monthStart.set(Calendar.MONTH,month-1);
        return monthStart.getTime();
    }

    public static Date getMonthStart(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar monthStart = Calendar.getInstance();
        monthStart.clear();
        monthStart.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        monthStart.set(Calendar.MONTH,calendar.get(Calendar.MONTH));
        return monthStart.getTime();
    }

    public static Date getMonthEnd(int year,int month){
        Calendar monthEnd = Calendar.getInstance();
        monthEnd.clear();
        monthEnd.set(Calendar.YEAR, year);
        monthEnd.set(Calendar.MONTH, month);
        return  DateUtils.addSeconds(monthEnd.getTime(), -1);
    }
    public static Date getMonthEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar monthEnd = Calendar.getInstance();
        monthEnd.clear();
        monthEnd.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
        monthEnd.set(Calendar.MONTH,calendar.get(Calendar.MONTH) + 1);
        return DateUtils.addSeconds(monthEnd.getTime(), -1);
    }


    public static void main(String[] args) {
        System.out.println(getNowYearStart().toLocaleString());
        System.out.println(getNowYearEnd().toLocaleString());
        System.out.println(getYearStart(2019).toLocaleString());
        System.out.println(getYearEnd(2019).toLocaleString());

        System.out.println(getMonthStart(2019,2).toLocaleString());
        System.out.println(getMonthEnd(2019,2).toLocaleString());

        System.out.println(getDayStart(new Date()).toLocaleString());
        System.out.println(getDayEnd(new Date()).toLocaleString());


        System.out.println(getNowMonthStart().toLocaleString());
        System.out.println(getNowMonthEnd().toLocaleString());

        System.out.println(getMonthStart(new Date()).toLocaleString());
        System.out.println(getMonthEnd(new Date()).toLocaleString());
    }

}
