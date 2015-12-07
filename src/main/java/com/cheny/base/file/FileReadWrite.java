package com.cheny.base.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FileReadWrite {

    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("A.txt");
            fos.write("d".getBytes("UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);
            try {
                dos.write("哈哈哈".getBytes("utf-8"));
                dos.flush();
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[]b = new byte[100];
            FileInputStream fis = new FileInputStream("A.txt");
            fis.read(b);
            DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream("A.txt")));
            int readLengt;
            try {
                while ((readLengt = dis.read()) != -1) {
                    System.out.println((char)readLengt);
                }
                System.out.println(new String(b, "utf-8"));
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
