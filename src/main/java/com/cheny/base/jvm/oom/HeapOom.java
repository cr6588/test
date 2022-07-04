package com.cheny.base.jvm.oom;

import java.util.ArrayList;
import java.util.List;


public class HeapOom {

    /**
     * VM Args: -Xms20m -Xmx20m -XX:HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=xxxx/target/heapOom.hprof
     */
    public static void main(String[] args) {
        List<HeapOom> list = new ArrayList<>();
        while(true) {
            list.add(new HeapOom());
        }
    }

}
