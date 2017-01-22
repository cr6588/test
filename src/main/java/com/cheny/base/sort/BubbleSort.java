package com.cheny.base.sort;

public class BubbleSort extends Object {
    public static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1 - i ; j++) {
                if(array[j] < array[j+1]) {
                    int temp = array[j+1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(array[array.length - 1-i]);
        }
    }
    public static void main(String[] args) {
        int[] array = {1,11,23,22,45,111,43,34,21,2,54,234,435,4,55};
        sort(array);
        String s1 = "ss",s2 = new String("ss");
        System.out.println(s1 == s2);
        int a = 0, b = 0;
    }
}
