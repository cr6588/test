package com.cheny.base.thread;

public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("run ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("sleep thread was interrupted");
        }
    }

    public static void main(String[] args) {
        ExtendsThread et = new ExtendsThread();
        et.start();
        et.interrupt();
        System.out.println("main");
    }
}
