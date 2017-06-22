package com.Lin.main;

import com.Lin.utils.DataUtil;
import com.Lin.utils.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/12.
 */
public class Chapter3 {
    public static void main(String[] args) throws IOException {
        IOUtil ioUtil = new IOUtil();
        DataUtil dataUtil = new DataUtil();
        //1. 读取啊.pot
        String srcPath = "子任务3/啊.pot";
        File file = new File(srcPath);
        byte[] bytes = ioUtil.getDAT(srcPath, file.length());
        //2. 获取点坐标序列 及序列变换
        ArrayList<String> xyList = dataUtil.getXY(bytes);
        for (String str:xyList){
            System.out.println(str);
        }

        ArrayList<String> xyList80 = dataUtil.getXY80(bytes);
        for (String str:xyList80){
            System.out.println(str);
        }

        ArrayList<String> xyList20 = dataUtil.getXY20(bytes);
        for (String str:xyList20){
            System.out.println(str);
        }

        //3. 放入pot
        ioUtil.put2File(xyList);
        ioUtil.put2File80(xyList80);
        ioUtil.put2File20(xyList20);


    }
}
