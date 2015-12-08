package com.cheny.base.thread;

public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("run ...");
    }

    public static void main(String[] args) {
        new ExtendsThread().start();
        System.out.println("main");
    }
}
