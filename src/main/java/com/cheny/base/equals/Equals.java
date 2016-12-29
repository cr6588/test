package com.cheny.base.equals;

public class Equals {
    public static void main(String []args) {
        int i = 0, j = 0;
        Integer a = 0, b = 0;
        System.out.println(i == j);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        a = 127;
        b = 127;
        System.out.println(a == b);
        System.out.println(a.equals(b));
        a = 128;
        b = 128;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
