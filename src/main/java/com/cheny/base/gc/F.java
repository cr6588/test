package com.cheny.base.gc;

public class F {
    static F f = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        //付给成员变量，重新建立引用，避免被gc
        f = this;
    }

    public static void main(String[] args) throws InterruptedException {
        f = new F();

        //第一次
        f = null;
        System.gc();
        //finalize方法优先级很低，等待
        Thread.sleep(1000);
        if(f == null) {
            System.out.println(" i am dead");
        } else {
            System.out.println(" i am alive");
        }

        //finalize方法只会执行一次
        //第二次
        f = null;
        System.gc();
        Thread.sleep(1000);
        if(f == null) {
            System.out.println(" i am dead");
        } else {
            System.out.println(" i am alive");
        }
    }
}
