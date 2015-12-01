package test;

import org.junit.Test;

public class BaseDataTypeInitValueTest {

    @Test
    public void test() {
        short s[] = new short[1];int i[] = new int[1];long l[] = new long[1]; byte b[] = new byte[1]; char c[] = new char[1]; boolean bo[] = new boolean [1]; float f[] = new float[1]; double d[] = new double[1];
        System.out.println("short init value is " + s[0]);
        System.out.println("int init value is " + i[0]);
        System.out.println("long init value is " + l[0]);
        System.out.println("byte init value is " + b[0]);
        System.out.println("char init value is " + c[0]);
        System.out.println("boolean init value is " + bo[0]);
        System.out.println("float init value is " + f[0]);
        System.out.println("double init value is " + d[0]);
        System.out.println(new String("s").equals(new String("s")));
    }

}
