package test.thread;

import org.junit.Test;

import com.cheny.base.thread.StaticMethodLoack;
import com.cheny.web.util.StringUtil;

public class threadTest {

    @Test
    public void test() {
        StaticMethodLoack staticMethodLoack = new StaticMethodLoack();
        Thread t1 = new Thread(staticMethodLoack);
        t1.start();
        System.out.println(StringUtil.isBlank("", ""));;
    }

}
