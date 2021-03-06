package com.cheny.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImplementsRunnable implements Runnable {
    String str;
    public boolean flag;
    ImplementsRunnable next;
    char[] ch = { 'a', 'b', 'c' };
    // private static Object lock=new Object();
    private static byte[] lock = new byte[0];
    private static Lock reenTrantLock = new ReentrantLock();
    private static Condition condition = reenTrantLock.newCondition();

    public ImplementsRunnable(String str, boolean flag) {
        this.str = str;
        this.flag = flag;
    }

    private int count = 0;

    @Override
    public void run() {
        // synchronizedPrint();
        reentrantLockPrint();
    }

    public void change(String str, char[] ch) {
        this.str = str;
        ch[0] = 'g';
    }

    public void synchronizedPrint() {
        synchronized (lock) {
            for (; count < 10;) {
                if (flag) {
                    System.out.println(++count + " " + this.str + " ");
                    this.next.flag = true;
                    this.flag = false;
                    lock.notifyAll();
                } else {
                    try {
                        System.out.println(this.str + " wait" + " ");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void reentrantLockPrint() {
        reenTrantLock.lock();
        for (; count < 10;) {
            if (flag) {
                System.out.println(++count + " " + this.str);
                this.next.flag = true;
                this.flag = false;
                condition.signalAll();
            } else {
                try {
                    System.out.println(this.str + " wait" + " ");
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        reenTrantLock.unlock();
    }

    public ImplementsRunnable getNext() {
        return next;
    }

    public void setNext(ImplementsRunnable next) {
        this.next = next;
    }

    public static void main(String[] args) {
        ImplementsRunnable irA = new ImplementsRunnable("A", true);
        ImplementsRunnable irB = new ImplementsRunnable("B", false);
        ImplementsRunnable irC = new ImplementsRunnable("C", false);
        irA.setNext(irB);
        irB.setNext(irC);
        irC.setNext(irA);

        // Thread thread1 = new Thread(irA);
        // Thread thread2 = new Thread(irB);
        // Thread thread3 = new Thread(irC);
        // thread1.start();
        // thread2.start();
        // thread3.start();

        ImplementsRunnable test = new ImplementsRunnable("D", false);
        test.change("AAA", test.ch);
        System.out.println(test.str + " " + test.ch[0] + test.ch[1] + test.ch[2]);
    }
}
