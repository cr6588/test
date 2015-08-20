package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class test {

    @Test
    @Ignore
    public void test() {
        int[] arrays = { 1, 5 ,6 ,2 ,10 ,6 ,9 , 3 ,4};
        quickSort(arrays, 0 , arrays.length - 1);
        for(int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    private void MaoPao(int[] arrays) {
        for(int i = 0; i < arrays.length; i ++) {
            for(int j = 0; j < arrays.length - 1; j++) {
                if(arrays[j] < arrays[j + 1]) {
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
        for(;j > i;) {
            for(;j > i; j--) {
                if(key > arrays[j]) {
                    int t = arrays[j];
                    arrays[j] = key;
                    arrays[i] = t;
                    break;
                }
            }
            for(;j > i; i++) {
                if(key < arrays[i]) {
                    int t = arrays[i];
                    arrays[i] = key;
                    arrays[j] = t;
                    break;
                }
            }
        }
        if(l < i - 1) {
            quickSort(arrays, l , i - 1);
        }
        if( i + 1 < h) {
            quickSort(arrays, i + 1 , h);
        }
    }

    @Test
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
        for(Test1 test1:test1s) {
            if(i==1) {
                test1s.addAll(list);
            }
            i++;
        }
    }
    public class Test1 {
        List<Test1> test1s;

        public List<Test1> getTest1s() {
            return test1s;
        }

        public void setTest1s(List<Test1> test1s) {
            this.test1s = test1s;
        }
        
    }

}
