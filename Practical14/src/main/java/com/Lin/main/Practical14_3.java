package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 * 读取源文件内容
 */
public class Practical14_3 {
    public static void main(String[] args) throws Exception {
        IOutil str = new IOutil();
        ArrayList<String > value = str.readfile("test_file");
        System.out.println(value);
    }
}
