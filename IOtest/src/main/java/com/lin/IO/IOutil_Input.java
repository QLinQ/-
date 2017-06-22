package com.lin.IO;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/20.
 */
public class IOutil_Input {

    public ArrayList<String> inputStream(String path) throws IOException {
        ArrayList<String> stream = new ArrayList<String>();

        //创建字节输入流
        FileInputStream fis = new FileInputStream(path);
        //创建长度为1024字节的临时存储
        byte[] fisbuf = new byte[1024];
        //创建长度控制变量
        int hasRead = 0;
        try {
            //循环读取
            while ((hasRead = fis.read(fisbuf)) > 0) {
                //将字节流数组读取的数据，转化为字符串并输出
                String buf = new String(fisbuf, 0, hasRead);
                stream.add(buf);
            }
        }
        catch (IOException e){
            System.out.println("读取发生异常！");
        }
        finally {
            fis.close();
            System.out.println("stream Done!");
            return stream;
        }
    }

    public ArrayList<String> Reader(String path) throws IOException{
        ArrayList<String> reader = new ArrayList<String>();

        FileReader fr = new FileReader(path);
        //创建32字节的临时存储
        char[] frbuf = new char[32];
        //创建实际读取的字节数控制变量
        int hasRead = 0;
        try{
            while((hasRead = fr.read(frbuf)) > 0){
                //将字符数组，转化为字符串输出
                String buf = new String(frbuf, 0, hasRead);
                reader.add(buf);
            }
        }
        catch(IOException e){
            System.out.println("读取发生异常！");
        }finally {
            fr.close();
            System.out.println(" read Done!");
            return reader;
        }
    }
}
