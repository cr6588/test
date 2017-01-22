package com.cheny.base.design.pattern;

public class Singleton {

    private static Singleton instance = null;

    private Singleton() {
        // TODO Auto-generated constructor stub
    }

    public synchronized static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
