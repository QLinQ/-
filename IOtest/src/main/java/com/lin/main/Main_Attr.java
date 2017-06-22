package com.lin.main;

import com.lin.IO.IOutil_FileAttr;
import com.lin.structclass.FileAttribute;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/19.
 */
public class Main_Attr {
    public static void main(String[] args) {
        IOutil_FileAttr io_fa = new IOutil_FileAttr();

        /*
        *standardoutput()方法将内容输出到标准输出，被复写以实现两种集合类型数据的输出
        * 参数分别为：
        *   ArrayList<FileAttribute>
        *   HashMap<String,String>
        */
        ArrayList<FileAttribute> fa_list = io_fa.recognition("usrfile");
        io_fa.standardoutput(fa_list);//输出文件属性类的列表

        HashMap<String,String> mp = io_fa.filemap(fa_list);
        io_fa.standardoutput(mp);//输出筛选的文件属性字典
    }
}
