package com.cr.util.thread;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CyclicBarrierTest {
    @Test
    public void test() {
        Runnable barrierAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("集合完成，开始执行...");
            }
        };
        CyclicBarrier cb = new CyclicBarrier(5, barrierAction);
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                System.out.println("开始集合：");
                try {
                    Thread.sleep(1000);
                    System.out.println(temp + "集合完成");
                    cb.await();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
