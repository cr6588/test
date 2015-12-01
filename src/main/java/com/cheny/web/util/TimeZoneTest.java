package com.cheny.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {
    public static void main(String args[]) {
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Berlin");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        sdf.setTimeZone(timeZone);
        System.out.println(sdf.format(new Date()));
        TimeZone GMT_1 =TimeZone.getTimeZone("Etc/GMT-1");
        sdf.setTimeZone(GMT_1);
        System.out.println(sdf.format(new Date()));
    }
}
