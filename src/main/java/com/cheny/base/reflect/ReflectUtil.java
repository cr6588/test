package com.cheny.base.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil extends B {

    private String str = "sss";
    protected int num;

    public static void setFieldDefaultValue(Object o) {
        
//返回一个字段对象数组，反映由类或接口所声明的类或接口所表示的所有字段。这包括公共的、受保护的、默认的（包）访问和私有字段，但不包括继承的字段。
//如果这个类对象表示一个类或接口，没有声明的字段，则该方法返回一个长度为0的数组。
//如果这个类对象表示一个数组类型，一个原始类型，或空白，那么这个方法返回一个长度为0的数组。
//返回的数组中的元素没有排序，并没有在任何特定的顺序。
//            Field[] fields = o.getClass().getDeclaredFields();
            List<Field[]> fieldList = new ArrayList<>();
//        返回一个包含字段对象的数组，它反映了这个类对象所表示的类或接口的所有可访问公共字段。
//        如果这个类对象表示一个类或接口，没有任何不可访问的公共字段，则此方法将返回一个长度为0的数组。
//        如果这个类对象代表一个类，那么这个方法返回类和其所有父类的公共领域。
//        如果这类对象表示一个接口，那么这个方法返回的接口和它所有的超接口等。
//        如果这个类对象表示一个数组类型，一个原始类型，或空白，那么这个方法返回一个长度为0的数组。
//        返回的数组中的元素没有排序，并没有在任何特定的顺序。
//        Field[] fields = o.getClass().getFields();
        Class<?> clazz = o.getClass() ;  
        
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {  
            try {  
                Field[] tempfields = clazz.getDeclaredFields() ;
                if(tempfields.length != 0) {
                    fieldList.add(tempfields);
                }
            } catch (Exception e) {  
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。  
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了  
            }   
        }  
        for (Field[] fields : fieldList) {
            for(int i = 0; i < fields.length; i++) {
//            if(fields[i].getType().isInstance(String)) {
//                
//            }
                System.out.println(fields[i].getType() );
                if(fields[i].getGenericType().toString().equals("class java.lang.String")) {
                    try {
                        fields[i].setAccessible(true);
                        String value = " update";
                        if(fields[i].get(o) != null) {
                            value = fields[i].get(o).toString() + value;
                        }
                        fields[i].set(o, value);
                        System.out.println(fields[i].get(o).toString());
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
    }
    public static void main(String[] args) {
        ReflectUtil reflectUtil =  new ReflectUtil();
        ReflectUtil.setFieldDefaultValue(reflectUtil);
        System.out.println(reflectUtil.str);
    }
}

