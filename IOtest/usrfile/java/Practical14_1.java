package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/6/16.
 */
public class Practical14_1 {
    public static void main(String[] args) {
        IOutil str = new IOutil();
        ArrayList<String> list = str.traverseFolder2("test_file");
        System.out.println(list);
    }
}
