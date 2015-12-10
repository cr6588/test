package com.cheny.base.design.pattern;

public class Test {

    public static class Inner {

        public final static Test testInstance = null;

        static {
            System.out.println("TestInner Static!");
        }
    }

    public static Test getInstance() {
        return Inner.testInstance;
    }

    public Test(int i) {
        System.out.println("Test " + i + " Construct! ");
    }
    public static Test testOut = new Test(1);

    static {
        System.out.println("Test Stataic");
    }


    public static void main(String args[]) {
        Test t = new Test(2);
        Test.getInstance();
    }

}
