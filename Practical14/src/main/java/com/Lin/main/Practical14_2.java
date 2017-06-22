package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 * 根据源文件名，构建新的目标文件名
 */
public class Practical14_2 {
    public static void main(String[] args) {
        IOutil str = new IOutil();
        ArrayList<String> list = str.goelpath("test_file");
        System.out.println(list);
    }
}
