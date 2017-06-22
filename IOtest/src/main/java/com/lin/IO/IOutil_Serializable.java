package com.lin.IO;

import com.lin.structclass.Serializable_test;

import java.io.*;

/**
 * Created by Administrator on 2017/6/20.
 */
public class IOutil_Serializable {

    public void Seri_output(String path) throws IOException {
        //创建一个处理流，封装的是FileOutputStream字节输出节点流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        try {
            Serializable_test st = new Serializable_test("test", 20);
            //使用ObjectOutputStream对象的writeObject()方法进行对象的序列化并写入输出流
            oos.writeObject(st);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("Done!");
            oos.close();
        }
    }

    public void Seri_input(String path) throws IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));

        try{
            Serializable_test st = (Serializable_test)ois.readObject() ;
            System.out.println("name:"+st.getName()+"\nage:"+st.getAge());
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done!");
            ois.close();
        }
    }
}
