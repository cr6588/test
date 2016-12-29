package test.proxy;

import org.junit.Test;

import com.cheny.proxy.FacadeProxy;
import com.cheny.proxy.IHello;

public class ProxyTest {

    @Test
    public void test() {
        IHello hello = FacadeProxy.newMapperProxy(IHello.class);  
        System.out.println(hello.say("hello world"));
    }

}
