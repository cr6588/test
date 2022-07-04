package com.cheny.base.jvm.oom;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import sun.misc.Unsafe;


/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    //1.8未受到MaxDirectMemorySize影响
    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

    //不使用list.add也不会oom?书中有问题还是1.7?
//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        int size = 1024 * 1024;
//        System.out.println(sun.misc.VM.maxDirectMemory());
//        List<ByteBuffer> list = new ArrayList<ByteBuffer>();
//        while (true) {
//            list.add(ByteBuffer.allocateDirect(size));
//        }
//    }
}
