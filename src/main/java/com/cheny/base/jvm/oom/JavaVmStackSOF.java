package com.cheny.base.jvm.oom;

/**
 * 不同的jdk最小值不一样
 * vm args: -Xss144k
 */
public class JavaVmStackSOF {
    private int stackLength = 1;

    /**
     * 一直调用自身增加栈深度
     */
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
