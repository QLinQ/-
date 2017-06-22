package com.Lin.urtils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.Array;
import java.sql.ResultSet;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/16.
 */
public class IOutil {

    //递归遍历文件夹，并保存根文件名
    public ArrayList<String> traverseFolder2(String path) {
        File file = new File(path);
        ArrayList<String> list = new ArrayList<String>();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file2.getAbsolutePath());
                        list.add(file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return list;
    }

    //构建目标输出的文件名
    public ArrayList<String> goelpath(String path) {
        // get file list where the path has
        File file = new File(path);
        // get the folder list
        File[] array = file.listFiles();
        ArrayList<String> newpath = new ArrayList<String>();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                // only take file name
                System.out.println("---filename:" + array[i].getName() + "---");

                String goelPath = "goel_file" + "\\" + array[i].getName();
                System.out.println(goelPath);
                newpath.add(goelPath);
            } else if (array[i].isDirectory()) {
                goelpath(array[i].getPath());
            }
        }
        return newpath;
    }

    /**
     * 判断文件的编码格式
     *
     * @param fileName :file
     * @return 文件编码格式
     * @throws Exception
     */
    public String codeString(String fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }

    //按行读取文件，并存入
    public ArrayList<String> readfile(String path) throws Exception {
        ArrayList<String> test_list = this.traverseFolder2(path);
        ArrayList<String> value_list = new ArrayList<String>();
        for (String temp : test_list) {
            FileInputStream fInputStream = new FileInputStream(temp);
            String code = this.codeString(temp);
            //code为上面方法里返回的编码方式
            InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, code);
            BufferedReader in = new BufferedReader(inputStreamReader);

            String strTmp = "";
            String strsum = "";
            //按行读取
            while ((strTmp = in.readLine()) != null) {
                strsum = strsum + strTmp;
            }
            value_list.add(strsum);
        }
        return value_list;
    }

    //分词并向目标文件按行输出分词内容
    public void set2goel(ArrayList<String> value) throws IOException {
        Lexeme lexeme;
        int i = 0;
        ArrayList<String> goel_path = this.goelpath("test_file");
        for (String val : value) {
            ArrayList<String> analyzeResult = new ArrayList<String>();
            IKSegmenter iks = new IKSegmenter(new StringReader(val), true);
            while ((lexeme = iks.next()) != null) {
                String str = lexeme.getLexemeText();
                analyzeResult.add(str + "\n");
            }
            File file = new File(goel_path.get(i));
            FileOutputStream fop = new FileOutputStream(file);

            try {
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                for (String word : analyzeResult) {
                    byte[] contentInBytes = word.getBytes();
                    fop.write(contentInBytes);
                }
                fop.flush();
                fop.close();

                System.out.println("Done");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fop != null) {
                        fop.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            i = i + 1;
        }
    }
}




