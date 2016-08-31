package com.cheny.web.util;

public class StringUtil {
    public static synchronized boolean isBlank(String str) {
        System.out.println("str");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (str.equals("")) {
            return true;
        }
        return false;
    }8

    public void print() {
        System.out.println("print");
    }

    public static synchronized boolean isBlank(String str, String s2) {
        System.out.println("str,s2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        if (str.equals("")) {
            return true;
        }
        return false;
    }
}
