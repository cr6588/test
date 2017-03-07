package com.cheny.base.thread;

public class ThreadLocalUse implements Runnable {
    //每个线程有自己的一份本地变量
    private static ThreadLocal<String> th = new ThreadLocal<String>();

    public static String getTh() {
        return th.get();
    }

    public static void setTh(String str) {
        th.set(str);
    }

    @Override
    public void run() {
        th.set("123");
        System.out.println(getTh());
    }
}
