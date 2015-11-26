package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cheny.web.bean.I18n;
import com.cheny.web.bean.Load;

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

}
