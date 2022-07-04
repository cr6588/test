package com.cr.util.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockTest {

    private Lock lock = new ReentrantLock();
    public void lock() {
        while (true) {
            try {
                String name = Thread.currentThread().getName();
                if(lock.tryLock()) {
                    System.out.println(name + " get lock, sleep 1");
                    Thread.sleep(5000);
                    lock.unlock();
                    Thread.sleep(100);
                } else {
                    System.out.println(name + " do not get lock, sleep 1");
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Test
    public void test() {
        LockTest a = new LockTest();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                a.lock();
            });
            threadList.add(t);
        }
        for (Thread thread : threadList) {
            thread.start();
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
