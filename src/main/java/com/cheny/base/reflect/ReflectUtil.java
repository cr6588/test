package com.cheny.base.reflect;

import java.lang.reflect.Field;

public class ReflectUtil {

    String str = "sss";
    int num;

    public static void objectFieldToDefaultValue(Object o) {
        Field[] fields = o.getClass().getDeclaredFields() ;
        for(int i = 0; i < fields.length; i++) {
//            if(fields[i].getType().isInstance(String)) {
//                
//            }
            if(fields[i].getGenericType().toString().equals("class java.lang.String")) {
                try {
                    fields[i].set(o, "");
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        ReflectUtil reflectUtil =  new ReflectUtil();
        ReflectUtil.objectFieldToDefaultValue(reflectUtil);
        System.out.println(reflectUtil.str);
        String s = "";
        if( s.getClass().getName() instanceof String) {
            System.out.println("ssssss");
        }
    }
}

