package test;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    @Test
    public void test() {
        JedisPool pool = new JedisPool("localhost", 6379);
        Jedis jedis = pool.getResource();
        long i = 0l;
        while(true) {
            
            jedis.set(i + "", "minxr");
            i++;
        }
        
    }

}
