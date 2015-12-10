package com.cheny.base.task;

import java.text.SimpleDateFormat;

public class BaseXmlTask {

    public static boolean main = false;

    public void task() {
        if (!main) {
            return;
        }
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + ":xml 定时任务");
    }
}
