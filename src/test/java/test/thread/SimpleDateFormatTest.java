package com.cr.util.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SimpleDateFormatTest {

    private static final ThreadLocal<SimpleDateFormat> date = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        }
    };
    private static final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    @Test
    public void threadUnSafeTest() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    Date d = new Date();
                    String str = f.format(d);
                    try {
                        Date c = f.parse(str);
                        String str2 = f.format(c);
                        System.out.println(str.equals(str2));
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void threadSafeTest() {
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    Date d = new Date();
                    String str = date.get().format(d);
                    try {
                        Date c = date.get().parse(str);
                        String str2 = date.get().format(c);
                        System.out.println(str.equals(str2));
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t.start();
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
