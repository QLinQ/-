package com.Lin.main;

import com.Lin.utils.DataUtil;
import com.Lin.utils.IOUtil;

import java.io.File;

/**
 * Created by 14012 on 2017/6/12.
 */
public class Chapter2 {
    public static void main(String[] args) {
        IOUtil ioUtil = new IOUtil();
        DataUtil dataUtil = new DataUtil();

        //1. 读取Character_A8
        String srcPath = "子任务2/Character_A_8.pot";
        File file = new File(srcPath);
        byte[]srcBytes = ioUtil.getDAT(srcPath, file.length());
        //2. 读取Character_Set
        srcPath = "子任务2/Character_Set.pot";
        file = new File(srcPath);
        byte[] srcSetBytes = ioUtil.getDAT(srcPath, file.length());

        //3. 匹配编码
        byte[] resultBytes = dataUtil.selectCharacter(srcSetBytes, srcBytes);
        //4. 输出到A.pot
        ioUtil.byte2Pot(resultBytes,"reslut.pot");
    }
}
