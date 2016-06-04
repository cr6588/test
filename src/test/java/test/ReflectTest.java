package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.cheny.web.bean.Load;

public class ReflectTest {

    @Test
    public void test() {
        Load load = new Load();
        Field [] fields = getField(load.getClass());
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName() + " " + fields[i].getType());
        }
//        String s = "s";
//        Package sPackage = s.getClass().getPackage();
//        Package loadPackage = load.getClass().getPackage();
    }

    public static Field[] getField(Class<?> clazz) {
        Field[] fields = null ;
        fields = clazz.getDeclaredFields();
        List<Field> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            if(!isJavaOwnerType(fields[i].getType())) {
                //属性类型是类本生的略过，不然无限循环
                if(fields[i].getType() != clazz) {
                    Field[] fi = getField(fields[i].getType());
                    for(int j = 0; j < fi.length; j++) {
                        list.add(fi[j]);
                    }
                }
            } else {
                list.add(fields[i]);
            }
        }
        Field[] f = new Field[list.size()];
        return list.toArray(f);
    }
    public static boolean isJavaOwnerType(Class<?> t) {
        if(t.isEnum()) {
            return true;
        } else if(t.isPrimitive()) {
            return true;
        }
        else if (!t.getPackage().getName().split("\\.")[0].equals("java")) {
            return false;
        }
        return true;
    }
}
