package com.cheny.base.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -Xmx6m
 * jdk7起运行时常量池在堆中所以使用堆限制
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int i = 0;
        while(true) {
//            intern()方法长量池有值则返回引用，没有加入后返回引用
            set.add(String.valueOf(i++).intern());
        }
    }
}
