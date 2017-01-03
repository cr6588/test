package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TryCatchFinallyReturnTest {

//    1、不管有木有出现异常，finally块中代码都会执行；
//    2、当try和catch中有return时，finally仍然会执行；
//    3、finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），所以函数返回值是在finally执行前确定的；
//    4、finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。
    public int printFinallyHasReturn() {
        int c = 1;
        try {
            c++;
            System.out.println("try执行中...");
            return c+100; //--------1
        } catch (Exception e) {
            e.printStackTrace();
            //return c;   //--------4
        } finally {
            c++;
            System.out.println("finally执行中...");
            return c;  //--------2
        }
        //return c;   //---------3
    }

    public static int printFinallyNoReturn() {
        int c = 1;
        try {
            c++;
            System.out.println(c);
            System.out.println("try");
            return c+100; //--------1
        }finally {
            c++;
            System.out.println(c);
            System.out.println("finally");
           
        }
    }
    @Test
    public void printTest() {
        System.out.println(printFinallyHasReturn());
        System.out.println(printFinallyNoReturn());
    }

}
