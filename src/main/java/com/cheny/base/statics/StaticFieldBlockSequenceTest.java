package com.cheny.base.statics;

public class StaticFieldBlockSequenceTest {

    // 1.
    public static String username = "static field";
    // 3.
    public String password = "field";
    // 2.
    static {
        System.out.println(username);
        System.out.println("static block");
    }
    // 4.
    {
        System.out.println(password);
        System.out.println("block");
    }

    // 5.
    public StaticFieldBlockSequenceTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        new StaticFieldBlockSequenceTest();
    }

    public String str;
    public void setStr(String str) {
        System.out.println("set str");
    }
}
