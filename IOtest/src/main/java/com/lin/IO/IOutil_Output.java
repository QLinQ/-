package com.lin.IO;

import java.io.*;

/**
 * Created by Administrator on 2017/6/20.
 */
public class IOutil_Output {

    public void outputStream(String inpath, String outpath) throws IOException {
        FileInputStream fis = new FileInputStream(inpath);
        FileOutputStream fos = new FileOutputStream(outpath);
        byte[] fsbuf = new byte[32];
        int hasRead = 0;
        try{
            while((hasRead = fis.read(fsbuf))> 0 ){
                fos.write(fsbuf, 0, hasRead);
            }
        }catch(IOException e){
            System.out.println("文件读写异常！");
        }finally {
            fis.close();
            fos.close();
            System.out.println("Done!");
        }
    }

    public void writer(String inpath, String outpath) throws IOException {
        FileReader fr = new FileReader(inpath);
        FileWriter fw = new FileWriter(outpath);
        char[] fbuf = new char[32];
        int hasRead = 0;
        try{
            while((hasRead = fr.read(fbuf))> 0 ){
                fw.write(fbuf, 0, hasRead);
            }
        }catch(IOException e){
            System.out.println("文件读写异常！");
        }finally {
            fr.close();
            fw.close();
            System.out.println("Done！");
        }
    }
}
