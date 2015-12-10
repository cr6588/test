package com.cheny.base.design.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用内部类来维护单例的实例
 * 当 StaticSingleton 被加载时，其内部类并不会被初始化
 * 故可以确保当 StaticSingleton 类被载入 JVM 时，不会初始化单例类，而当 getInstance() 方法调用时
 * 才会加载 SingletonHolder，从而初始化 instance.
 * 同时，由于实例的建立是时在类加载时完成，故天生对多线程友好，getInstance() 方法也无需使用同步关键字。
 *
 */
public  class SingLazy implements Runnable{

    private static SingLazy sing = null;

    private SingLazy() {
        // TODO Auto-generated constructor stub
        System.out.println("StaticSingleton is create");
    }

    private static class SingInit {
        public static SingLazy getSingLazy() {
            if (sing == null) {
                sing = new SingLazy();
            }
            return sing;
        }
    }

    public static SingLazy getSing() {
//        if(sing == null) {
//            sing = new SingLazy();
//        }
//        return sing;
        return SingInit.getSingLazy();
    }

    public static void main(String[] args) {
//        SingLazy s1 = getSing();
//        SingLazy s2 = getSing();
//        SingLazy s3 = getSing();
//        SingLazy s4 = getSing();
//        System.out.println(s1.toString());
//        System.out.println(s2.toString());
//        System.out.println(s3.toString());
//        System.out.println(s4.toString());
        List<Thread> threadList = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            Thread t = new Thread(new SingLazy());
            threadList.add(t);
        }
        for(Thread t : threadList) {
            t.start();
        }
//        Iterator<Thread> it = threadList.iterator();
//        while (it.hasNext()) {
//            it.next().start();
//        }
    }

    @Override
    public void run() {
        System.out.println(getSing().toString());
    }
}
