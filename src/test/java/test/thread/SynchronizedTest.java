package com.cr.util.thread;

import org.junit.Test;

public class SynchronizedTest {
    class A {
        public synchronized void sync1() {
            while (true) {
                System.out.println("sync1");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public synchronized void sync2() {
            while (true) {
                System.out.println("sync2");
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test() {
        A a = new A();
        Thread t1 = new Thread(() -> {
            a.sync1();
        });
        Thread t2 = new Thread(() -> {
            a.sync2();
        });
        t1.start();
        t2.start();
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
