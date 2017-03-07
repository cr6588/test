package test.thread;

import org.junit.Test;

import com.cheny.base.thread.ThreadLocalUse;

public class ThreadLocalTest {

    
    @Test
    public void test() throws InterruptedException {
        Thread t = new Thread(new ThreadLocalUse());
        t.start();
        Thread.currentThread().sleep(2000);
        System.out.println(ThreadLocalUse.getTh());
    }

}
