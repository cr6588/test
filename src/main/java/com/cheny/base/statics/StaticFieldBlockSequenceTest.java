package com.cheny.base.statics;

public class StaticFieldBlockSequenceTest {
    public static String username = "static field";

    // 1.
    public static String username1 = username;
    static {
        System.out.println("static block");
        username = "s";
    }
    // 3.
    public String password = "field";
    // 2.
    // 4.
    {
        System.out.println(password);
        System.out.println("block");
        password = "s";
    }

    public String password1 = password;
    // 5.
    public StaticFieldBlockSequenceTest() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        StaticFieldBlockSequenceTest t = new StaticFieldBlockSequenceTest();
        System.out.println(username1);
        System.out.println(t.getPassword1());
    }

    public String str;
    public void setStr(String str) {
        System.out.println("set str");
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    
}
