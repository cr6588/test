package com.cheny.base.design.pattern;

public class Sing {

    private static Sing sing = null;

    private Sing() {
        // TODO Auto-generated constructor stub
    }

    public synchronized static Sing getSing() {
        if(sing == null) {
            sing = new Sing();
        }
        return sing;
    }
}
