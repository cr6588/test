package com.cheny.base.jvm.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * VM Args: -Xmx6m
 * jdk7起运行时常量池在堆中所以使用堆限制
 */
public class RuntimeConstantPoolOOM2 {
    public static void main(String[] args) {
        String str1 = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        //jdk11 true 未在常量池中创建过java ,jdk1.8 false 已在常量池中创建过java
        String str2 = new StringBuilder().append("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
