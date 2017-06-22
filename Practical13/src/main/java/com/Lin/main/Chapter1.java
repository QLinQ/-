package com.Lin.main;

import com.Lin.bean.DAT;
import com.Lin.bean.POT;
import com.Lin.utils.DataUtil;
import com.Lin.utils.IOUtil;
import java.io.File;
import java.io.IOException;

/**
 * Created by 14012 on 2017/6/9.
 */
public class Chapter1 {
    public static void main(String[] args) throws IOException {
        String tagPath = "chapter1/a.pot";
        //循环从目录读取文件
        File[] file = new File("DAT").listFiles();
        for (File f:file) {
            String srcPath ="DAT"+File.separator+f.getName();
            IOUtil ioUtil = new IOUtil();
            DataUtil dataUtil = new DataUtil();
            DAT dat = new DAT();
            POT pot =new POT();
            //从文件获取byte
            byte[] datByte = ioUtil.getDAT(srcPath,f.length());
            //分析DAT byte[]
            dataUtil.dealDat(dat,datByte);

            //DAT2POT
            dataUtil.Dat2Pot(dat,pot);

            //将pot转换为byte[]
            byte[] bytes = dataUtil.pot2Pot(pot,f.length());

            //将byte放入POT文件（追加）
            ioUtil.byte2Pot(bytes,tagPath);
        }

    }
}
