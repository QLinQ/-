package com.lin.main;

import com.lin.IO.IOutil_Serializable;

import java.io.IOException;

/**
 * Created by Administrator on 2017/6/20.
 */
public class Main_Seri {
    public static void main(String[] args) throws IOException {
        IOutil_Serializable iser = new IOutil_Serializable();

        iser.Seri_output("outputfile/seri_out");
        iser.Seri_input("outputfile/seri_out");
    }
}
