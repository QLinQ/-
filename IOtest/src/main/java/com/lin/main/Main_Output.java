package com.lin.main;

import com.lin.IO.IOutil_Output;

import java.io.IOException;


/**
 * Created by Administrator on 2017/6/20.
 */
public class Main_Output {
    public static void main(String[] args) throws IOException {
        IOutil_Output io_out = new IOutil_Output();

        io_out.outputStream("usrfile/back/back.txt","outputfile/outback.txt");
        io_out.writer("usrfile/frequencysum/sum.txt","outputfile/outsum.txt");
    }

}
