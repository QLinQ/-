package com.lin.main;

import com.lin.IO.IOutil_FileAttr;
import com.lin.IO.IOutil_Input;
import com.lin.structclass.FileAttribute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/20.
 */
public class Main_Input {
    public static void main(String[] args) throws IOException {
        IOutil_FileAttr io_fa = new IOutil_FileAttr();
        IOutil_Input io_in = new IOutil_Input();

        ArrayList<FileAttribute> fa_list = io_fa.recognition("usrfile");
        HashMap<String,String> mp = io_fa.filemap(fa_list);

        ArrayList<String> stream = io_in.inputStream(mp.get("back.txt"));
        ArrayList<String> reader = io_in.Reader(mp.get("sum.txt"));
        standardoutput(stream);
        standardoutput(reader);
    }

    public static void standardoutput(ArrayList<String> strlist){
        for(String buf : strlist){
            System.out.println(buf);
        }
    }
}
