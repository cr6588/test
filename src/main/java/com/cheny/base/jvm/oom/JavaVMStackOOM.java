package com.cheny.base.jvm.oom;

/**
 * vm args: -Xss2M
 * 栈内存越大，可建立线程数越少
 * ！！！！！！谨慎运行有可能假死
 */
public class JavaVMStackOOM {
    public void doneStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while(true) {
//            new Thread(() -> {
//                doneStop();
//            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
