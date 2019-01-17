/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbl.elegislature.util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author sandeep
 */
public class ReporterUtility {


    public static String getFirstWord(String input) {
        if (input == null) {
            return "";
        }
        String[] splited = input.split("\\s+");
        if (splited.length >= 1) {
            return splited[0];
        }
        return input;
    }

    public static int parseInt(String number) {
        int num = 0;
        try {
            num = Integer.parseInt(number);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }

    public static float parseFloat(String number) {
        float num = 0;
        try {
            num = Float.parseFloat(number);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }

    public static long parseLong(String number) {
        long num = 0;
        try {
            num = Long.parseLong(number);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }

    public static double parseDouble(String number) {
        double num = 0;
        try {
            num = Double.parseDouble(number);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return num;
    }

    public static boolean parseBoolean(String value) {
        boolean boolValue = false;
        try {
            boolValue = Boolean.parseBoolean(value.toLowerCase());
        } catch (Exception e) {
        }
        return boolValue;
    }

    public static boolean parseBoolean(Integer value) {
        if (value == null) {
            return false;
        }
        if (value != 0) {
            return true;
        }
        return false;
    }

    public static Date addMinute(Date date, int minute) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(date.getTime());
        calendarDate.add(Calendar.MINUTE, minute);
        date.setTime(calendarDate.getTimeInMillis());
        return date;
    }
    
    public static Date setDateTimeAsZero(Date date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(date.getTime());
        calendarDate.add(Calendar.HOUR, 0);
        calendarDate.add(Calendar.SECOND, 0);
        calendarDate.add(Calendar.MINUTE, 0);
        date.setTime(calendarDate.getTimeInMillis());
        return date;
    }

}
