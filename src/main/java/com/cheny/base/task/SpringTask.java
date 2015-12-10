package com.cheny.base.task;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@PropertySource("classpath:task.properties")
//@Component
public class SpringTask implements Runnable{

//    @Autowired
//    private Environment env;

    @Scheduled(fixedRate=2000) 
    public void outTaskTest() throws InterruptedException {
//        System.out.println(env.getProperty("task").toString());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "fixedRate测试");
        Thread.sleep(4000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "fixedRate定时恢复");
    }

    @Scheduled(fixedDelay=2000) 
    public void fixedDelayTaskTest() throws InterruptedException {
//        System.out.println(env.getProperty("task").toString());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "fixedDelay测试");
        Thread.sleep(4000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "fixedDelay定时恢复");
    }

    @Scheduled(cron="0/5 * * * * ?")
    public void cronTaskTest() throws InterruptedException {
//        System.out.println(env.getProperty("task").toString());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "cron测试");
        Thread.sleep(4000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()) + "cron定时恢复");
    }

    @Override
    public void run() {

    }
}
