package com.cheny.base.statics;

public class StaticFieldBlockSequenceTestChild extends StaticFieldBlockSequenceTest {

    public static String child = "child static field";
    public String pwd = "child field";
    static {
        System.out.println(child);
        System.out.println("child static block");
    }
    {
        System.out.println(pwd);
        System.out.println("child block");
    }

    public StaticFieldBlockSequenceTestChild() {
        System.out.println("child constructor");
    }

    public String str;

    public void setStr(String str) {
        System.out.println("child set str");
    }

    public static void main(String args[]) {
        new StaticFieldBlockSequenceTestChild().setStr("s");
    }
}
