package com.Lin.main;

import com.Lin.urtils.IOutil;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/16.
 */
public class Practical14_4 {
    public static void main(String[] args) throws Exception {
        IOutil str = new IOutil();
        ArrayList<String> val = new ArrayList<String>();
        val =str.readfile("test_file");
        str.set2goel(val);
    }
}
