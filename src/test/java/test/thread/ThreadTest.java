package test.thread;

import org.junit.Test;

import lombok.Data;

public class ThreadTest {
    static Object lock;
    @Data
    class Ins extends Thread {

        public Ins(String str) {
            this.str = str;
            this.flag = false;
        }
        private boolean flag;
        private String str;
        private Ins next;


        @Override
        public void run() {
            this.out();
        }

        public void out() {
            while(true) {
                synchronized (Ins.class) {
                    System.out.println("##" + str);
                    try {
                        if(flag) {
                            System.out.println(str);
                            Thread.sleep(1000L);
                            flag = false;
                            next.setFlag(true);
                            Ins.class.notifyAll();
                        }
                        Ins.class.wait();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Test
    public void sortTest() {
        Ins a = new Ins("a");
        Ins b = new Ins("b");
        Ins c = new Ins("c");
        a.setNext(b);
        b.setNext(c);
        c.setNext(a);
        a.setFlag(true);
        a.start();
        b.start();
        c.start();
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
