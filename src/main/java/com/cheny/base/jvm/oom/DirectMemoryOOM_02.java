package com.cheny.base.jvm.oom;

import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryOOM_02 {
    // -Xms10m -Xmx10m -XX:MaxDirectMemorySize=10m
    public static void main(String[] args) throws Exception {

        Runtime rt = Runtime.getRuntime();
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;

        int size = 1024 * 1024 * 1024;

        List<ByteBuffer> list = new ArrayList<ByteBuffer>();


        while (true) {

            System.out.println("************ start ***************************");

            System.out.println("JVM maxDirectMemory : " + sun.misc.VM.maxDirectMemory() / byteToMb);

            vmTotal = rt.totalMemory() / byteToMb;
            vmFree = rt.freeMemory() / byteToMb;
            vmMax = rt.maxMemory() / byteToMb;
            vmUse = vmTotal - vmFree;
            System.out.println("JVM内存已用的空间为：" + vmUse + " MB");
            System.out.println("JVM内存的空闲空间为：" + vmFree + " MB");
            System.out.println("JVM总内存空间为：" + vmTotal + " MB");
            System.out.println("JVM总内存空间为：" + vmMax + " MB");

            System.out.println("======================================");
            // 操作系统级内存情况查询
            OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            String os = System.getProperty("os.name");
            long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
            long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
            long physicalUse = physicalTotal - physicalFree;
            System.out.println("操作系统的版本：" + os);
            System.out.println("操作系统物理内存已用的空间为：" + physicalUse + " MB");
            System.out.println("操作系统物理内存的空闲空间为：" + physicalFree + " MB");
            System.out.println("操作系统总物理内存：" + physicalTotal + " MB");
            System.out.println("======================================");

            // 获得线程总数
            ThreadGroup parentThread;
            int totalThread = 0;
            for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                    .getParent() != null; parentThread = parentThread.getParent()) {
                totalThread = parentThread.activeCount();
            }
            System.out.println("获得线程总数:" + totalThread);

            System.out.println("======================================");

            // 分配 Direct Memory
            ByteBuffer by =  ByteBuffer.allocateDirect(size);
            list.add(by);

            System.out.println("************ end ***************************");


            Thread.sleep(1000);
        }
    }
}

