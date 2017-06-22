package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.omg.PortableServer.ServantActivatorOperations;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class FileIO {

    public static void main(String[] args) throws IOException {
        File file = new File(".");
        System.out.println(file.getName());
        System.out.println(file.getParent());

        //以系统当前时间为名称创建一个新文件
        File newfile = new File(System.currentTimeMillis()+"");
        System.out.println("对象是否存在："+ newfile.exists());
    }
}
