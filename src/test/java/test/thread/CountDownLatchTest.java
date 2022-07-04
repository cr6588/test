package com.cr.util.thread;

import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class CountDownLatchTest {
    @Test
    public void test() {
        CountDownLatch cdl = new CountDownLatch(5);
        for(int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("开始准备");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("准备完成");
                cdl.countDown();
            }).start();
        }
        try {
            cdl.await();
            System.out.println("准备完成，开始行动");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
