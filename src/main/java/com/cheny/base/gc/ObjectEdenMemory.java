package com.cheny.base.gc;

public class ObjectEdenMemory {
    private static final int _1MB = 1024 * 1024;
    /**
     * VM Args: -XX:+UseSerialGC -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails  -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
    }
}
