package com.cheny.base.gc;

public class JHSDB_TestCase {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done"); //设断点，查看staticObj，instanceObj，instanceObj变量本身存放在哪里
        }
    }
    private static class ObjectHolder {}

    /**
     * VM Args: -Xmx10m -XX:+UseSerialGC -XX:-UseCompressedOops
     * @param args
     */
    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
