package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.cheny.web.bean.I18n;
import com.cheny.web.bean.LoadCache;
import com.cheny.web.bean.LoadStatus;

public class test {

    @Test
    @Ignore
    public void test() {
        int[] arrays = { 1, 5, 6, 2, 10, 6, 9, 3, 4 };
        quickSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    private void MaoPao(int[] arrays) {
        for (int i = arrays.length - 1; i > 0; i++) {
            for (int j = 0; j < i; j++) {
                if (arrays[j] < arrays[j + 1]) {
                    int t = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = t;
                }
            }
        }
    }

    private void quickSort(int[] arrays, int l, int h) {
        int i = l, j = h;
        int key = arrays[i];
        for (; j > i;) {
            for (; j > i; j--) {
                if (key > arrays[j]) {
                    int t = arrays[j];
                    arrays[j] = key;
                    arrays[i] = t;
                    break;
                }
            }
            for (; j > i; i++) {
                if (key < arrays[i]) {
                    int t = arrays[i];
                    arrays[i] = key;
                    arrays[j] = t;
                    break;
                }
            }
        }
        if (l < i - 1) {
            quickSort(arrays, l, i - 1);
        }
        if (i + 1 < h) {
            quickSort(arrays, i + 1, h);
        }
    }

    @Test
    @Ignore
    public void test1() {
        Test1 a = new Test1();
        Test1 b = new Test1();
        List<Test1> test1s = new ArrayList<Test1>();
        test1s.add(a);
        test1s.add(b);
        Test1 c = new Test1();
        Test1 d = new Test1();
        List<Test1> list = new ArrayList<Test1>();
        list.add(c);
        list.add(d);
        int i = 0;
        for (Test1 test1 : test1s) {
            if (i == 1) {
                test1s.addAll(list);
            }
            i++;
        }
    }

    public class Test1 {
        List<Test1> test1s;
        public static final String str = "str";

        public List<Test1> getTest1s() {
            return test1s;
        }

        public Test1 change() {
            Test1 test1 = null;
            test1 = new Test2();
            return test1;
        }

        public void out() {
            System.out.println("test1");
        }

    }

    public class Test2 extends Test1 {
        @Override
        public void out() {
            System.out.println("test2");
        }
    }

    @Test
    @Ignore
    public void classMethodTest() {
        Test1 test = new Test1();
        test = test.change();
        System.out.println(test.str);
        test.out();
        test = new Test2();
        test.out();
        Test2 test2 = new Test2();
        test2.out();
    }

    @Test
    @Ignore
    public void byteUtf8test() throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("/logistics/pickupLoad", "UTF-8"));
    }

    JedisPool pool;
    Jedis jedis;

    public void setUp() {
        pool = new JedisPool("localhost", 6380);
        jedis = pool.getResource();
        jedis.auth("123456");
    }

    @Test
    @Ignore
    public void testGet() {
        System.out.println(jedis.get("lu"));
    }

    /**
     * Redis存储初级的字符串 CRUD
     * @throws Exception
     */
    @Test
    @Ignore
    public void testBasicString() throws Exception {
        // -----添加数据----------
        jedis.set("name", "minxr");// 向key-->name中放入了value-->minxr
        System.out.println(jedis.get("name"));// 执行结果：minxr

        // -----修改数据-----------
        // 1、在原来基础上修改
        this.setUp();
        jedis.append("name", "jarorwar"); // 很直观，类似map 将jarorwar
                                          // append到已经有的value之后
        System.out.println(jedis.get("name"));// 执行结果:minxrjarorwar
        // 2、直接覆盖原来的数据
        jedis.set("name", "闵晓荣");
        System.out.println(jedis.get("name"));// 执行结果：闵晓荣
        // 删除key对应的记录
        jedis.del("name");
        System.out.println(jedis.get("name"));// 执行结果：null
        /**
         * mset相当于 jedis.set("name","minxr"); jedis.set("jarorwar","闵晓荣");
         */
        jedis.mset("name", "minxr", "jarorwar", "闵晓荣");
        System.out.println(jedis.mget("name", "jarorwar"));
        I18n i18n = new I18n();
        i18n.setCode("11");
        Map<String, I18n> map = new HashMap<>();
        // 序列化
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
        oos.writeObject(i18n);
        byte[] bytes = baos.toByteArray();
        // map.put("i18n".getBytes(), i18n);
        // jedis.set
        jedis.set("i18n", "i18n");
        System.out.println(jedis.expire("i18n", 1));
        jedis.set("i18n".getBytes(), bytes);
        System.out.println(jedis.expire("i18n".getBytes(), 1));
        Thread.sleep(3000);
        jedis.get("i18n".getBytes());
        System.out.println("i18n ser:" + "i18n".getBytes());
        // 反序列化
        ByteArrayInputStream bais = null;
        bais = new ByteArrayInputStream(jedis.get("i18n".getBytes()));
        ObjectInputStream ois = new ObjectInputStream(bais);
        I18n i18nGet = (I18n) ois.readObject();
        System.out.println(i18nGet.getCode());
        System.out.println(jedis.get("i18n"));
    }

    /**
     * jedis操作Map
     */
    @Test
    @Ignore
    public void testMap() {
        Map<String, String> user = new HashMap<String, String>();
        user.put("name", "minxr");
        user.put("pwd", "password");
        jedis.hmset("user", user);
        // 取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        // 第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("user", "name");
        System.out.println(rsmap);
        // 删除map中的某个键值
        jedis.hdel("user", "pwd");
        System.out.println(jedis.hmget("user", "pwd")); // 因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); // 返回key为user的键中存放的值的个数1
        System.out.println(jedis.exists("user"));// 是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));// 返回map对象中的所有key [pwd, name]
        System.out.println(jedis.hvals("user"));// 返回map对象中的所有value [minxr,
                                                // password]
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    @Ignore
    public void testList() {
        // 开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        // 先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        // 再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));
    }

    /**
     * jedis操作Set
     */
    @Test
    @Ignore
    public void testSet() {
        // 添加
        jedis.sadd("sname", "minxr");
        jedis.sadd("sname", "jarorwar");
        jedis.sadd("sname", "闵晓荣");
        jedis.sadd("sanme", "noname");
        // 移除noname
        jedis.srem("sname", "noname");
        System.out.println(jedis.smembers("sname"));// 获取所有加入的value
        System.out.println(jedis.sismember("sname", "minxr"));// 判断 minxr
                                                              // 是否是sname集合的元素
        System.out.println(jedis.srandmember("sname"));
        System.out.println(jedis.scard("sname"));// 返回集合的元素个数
    }

    @Test
    @Ignore
    public void testGenerate() throws InterruptedException {
        // keys中传入的可以用通配符
        System.out.println(jedis.keys("*")); // 返回当前库中所有的key [sose, sanme, name,
                                             // jarorwar, foo, sname, java
                                             // framework, user, braand]
        System.out.println(jedis.keys("*name"));// 返回的sname [sname, name]
        System.out.println(jedis.del("sanmdde"));// 删除key为sanmdde的对象 删除成功返回1
                                                 // 删除失败（或者不存在）返回 0
        System.out.println(jedis.ttl("sname"));// 返回给定key的有效时间，如果是-1则表示永远有效
        jedis.setex("timekey", 10, "min");// 通过此方法，可以指定key的存活（有效时间） 时间为秒
        Thread.sleep(5000);// 睡眠5秒后，剩余时间将为<=5
        System.out.println(jedis.ttl("timekey")); // 输出结果为5
        jedis.setex("timekey", 1, "min"); // 设为1后，下面再看剩余时间就是1了
        System.out.println(jedis.ttl("timekey")); // 输出结果为1
        System.out.println(jedis.exists("key"));// 检查key是否存在
                                                // System.out.println(jedis.rename("timekey","time"));
        System.out.println(jedis.get("timekey"));// 因为移除，返回为null
        System.out.println(jedis.get("time")); // 因为将timekey 重命名为time 所以可以取得值
                                               // min
        // jedis 排序
        // 注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");// 先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); // [1, 3, 6, 9] //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    public class S {
        private LoadStatus status;

        public LoadStatus getStatus() {
            return status;
        }

        public void setStatus(LoadStatus status) {
            this.status = status;
        }

    }

    @Ignore
    @Test
    public void enumTest() {
        S s = new S();
        s.setStatus(LoadStatus.Onway);
        System.out.println(s.getStatus() == LoadStatus.Onway);
        
    }

    @Test
    public void varTest() throws Exception {
        LoadCache loadCache = new LoadCache();
        loadCache.remindTime = System.currentTimeMillis();
        loadCache.gpsTime = loadCache.remindTime;
        System.out.println(loadCache.gpsTime);
        Thread.sleep(2000);
        loadCache.remindTime = System.currentTimeMillis();
        System.out.println(loadCache.gpsTime);
    }
}
