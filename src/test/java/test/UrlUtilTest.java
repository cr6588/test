package test;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.junit.Test;

public class UrlUtilTest {

//    @Test
    public void utf8ToChinese() {
        try {
            String str = new String("\u7B2C1\u5929".getBytes("UTF-8"),  "utf-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
//    @Test
    public void test() {
        try {
            System.out.println(URLDecoder.decode("%25", "utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
//    @Test
    public void Test() {
        System.out.println("%h301".replaceAll("%(?![0-9a-fA-F]{2})", "%25"));
    }
//    @Test
    public void decodertest() {
        String str = "%3Cdiv%20class%3D%22tourSection_bohui%22%3E%3Cdiv%20class%3D%22tourContent_new%22%3E%3Cdiv%20class%3D%22day_title_new%22%3E%3Ch3%3E%3Cem%20contenteditable%3D%22true%22%3E%u7B2C1%u5929%3C/em%3E%3Cdiv%20contenteditable%3D%22true%22%3E%u8BF7%u5728%u8FD9%u91CC%u8F93%u5165%u884C%u7A0B%u6807%u9898%3C/div%3E%3C/h3%3E%3C/div%3E%3C/div%3E%3C/div%3E";
        String data = "";
        try {
            //(?!pattern) 非获取匹配，正向否定预查，在任何不匹配pattern的字符串开始处匹配查找字符串，该匹配不需要获取供以后使用。例如“Windows(?!95|98|NT|2000)”能匹配“Windows3.1”中的“Windows”，但不能匹配“Windows2000”中的“Windows”。
            data = str.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            data = data.replaceAll("\\+", "%2B");
            String s = URLDecoder.decode(data, "UTF8").replace("%", "\\");
            System.out.println(s);
            byte[] b = s.getBytes("gbk");
            System.out.println(new String(b, "gbk"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            System.out.println(URLDecoder.decode(data, "GBK"));

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            System.out.println(URLDecoder.decode(data, "ISO8859-1"));

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    @Test
    public void encodeTest() {
        String str = "<div class=\"tourSection_bohui\"><div class=\"tourContent_new\"><div class=\"day_title_new\"><h3><em contenteditable=\"true\">第1天</em><div contenteditable=\"true\">请在这里输入行程标题</div></h3></div></div></div>";
        String str1 = "%3Cdiv%20class%3D%22tourSection_bohui%22%3E%3Cdiv%20class%3D%22tourContent_new%22%3E%3Cdiv%20class%3D%22day_title_new%22%3E%3Ch3%3E%3Cem%20contenteditable%3D%22true%22%3E%u7B2C1%u5929%3C/em%3E%3Cdiv%20contenteditable%3D%22true%22%3E%u8BF7%u5728%u8FD9%u91CC%u8F93%u5165%u884C%u7A0B%u6807%u9898%3C/div%3E%3C/h3%3E%3C/div%3E%3C/div%3E%3C/div%3E";
        try {
            String encode = URLEncoder.encode(str.replace(" ", "%25"), "gbk");
            String encodeUtf8 = URLEncoder.encode(str, "utf-8").replace("+", "%20");
            for (int i = 0; i < str1.length(); i++) {
                if(str1.charAt(i) != encodeUtf8.charAt(i)) {
                    System.out.println(i);
                    System.out.println(str1.substring(i));
                    System.out.println(encodeUtf8.substring(i));
                    break;
                }
            }
            System.out.println(encode);
            System.out.println(str1);
            System.out.println(encodeUtf8);
            System.out.println(encode.equals(encodeUtf8));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void urlToFileTest() {
        OutputStream out = null;
        InputStream is = null;
        try {
            URL url = new URL("ftp://127.0.0.1/pic1.jpg"); //http与ftp都可以
            URLConnection con = url.openConnection();
            is = con.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            out = new FileOutputStream(new File(this.getClass().getResource("/").getPath() + "imgTemp"));
            while((len = is.read(bs)) != -1) {
                out.write(bs, 0, len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(is);
            closeStream(out);
        }
    }

    public void closeStream(Closeable stream) {
        if(stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
