package test.db;

import java.sql.PreparedStatement;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import test.random.RandomUtilTest;

import com.cheny.base.db.JDBC;
import com.cheny.base.file.FileUtil;
import com.cheny.base.random.RandomUtil;

public class JdbcTest {
    static String[] nameArray;
    static {
        String path = RandomUtilTest.class.getResource("").getPath() + "常用姓.txt";
        String names = FileUtil.readTxtFile2StrByStringBuffer(path).replace("\r\n", " ");
        nameArray = names.split(" ");
    }
    public static final String sex = "男女 ";
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";
    @Test
    public void test() {
        JDBC jdbc = new JDBC("jdbc:mysql://localhost:3306/test?allowMultiQueries=true&amp;useUnicode=true&amp;characterEncoding=UTF-8", "dev", "dev");
        String sql = "INSERT into `user`(username,password,realname,tel,address,company,sex,age,qq,email) values (?,?,?,?,?,?,?,?,?,?);";
        jdbc.setSql(sql);
        try {
            System.out.println(new Date().toString());
            PreparedStatement pst = jdbc.getPstmt();
            for(int i = 0; i < 10 * 20 * 3; i++) {
                for(int j = 0; j < 5000; j++) {
                    pst.setString(1, generateMixString(8));
                    pst.setString(2, generateMixString(8));
                    pst.setString(3, nameArray[RandomUtil.random.nextInt(nameArray.length)] + RandomUtil.getMaxLenthChineseStr(3));
                    pst.setString(4, "1" + RandomUtil.getNumStr(10));
                    pst.setString(5, RandomUtil.getMaxLenthChineseStr(20));
                    pst.setString(6, RandomUtil.getMaxLenthChineseStr(20));
                    pst.setString(7, RandomUtil.getRandomStrByStr(sex));
                    pst.setInt(8, RandomUtil.random.nextInt(60));
                    pst.setString(9, RandomUtil.getNumStr(9));
                    pst.setString(10, generateMixString(15));
                    pst.addBatch();
                }
                pst.executeBatch();
                jdbc.getCon().commit();
                pst.clearBatch();
            }
            System.out.println(new Date().toString());
            jdbc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateMixString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(letterChar.length())));
        }
        return sb.toString();
    }
}
