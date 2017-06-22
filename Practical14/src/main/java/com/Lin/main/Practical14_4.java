package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 * 读取源文件内容并写入目标文件
 */
public class Practical14_4 {
    public static void main(String[] args) throws Exception {
        IOutil str = new IOutil();
        ArrayList<String> val = new ArrayList<String>();
        val =str.readfile("test_file");
        str.set2goel(val);
    }
}
