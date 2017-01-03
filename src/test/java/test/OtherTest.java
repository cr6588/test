package test;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cheny.web.bean.I18n;

public class OtherTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void test() {
        I18n i = new I18n();
//        System.out.println("asdf".substring(0, 500));
        System.out.println(i.getText());
    }

    @Test
    public void stringTest() {
        String s = "ss";
        s+= "asdfsda" + "ssasdfasdfasdf";
        System.out.println(s);
    }

    public String exception () {
        try {
            throw new Exception("ss");
        } catch (Exception e) {
            System.out.println("sssssssss");
        }
        return "s";
    }

    @Test
    public void exceptionTest() {
        System.out.println(exception());
    }

}
