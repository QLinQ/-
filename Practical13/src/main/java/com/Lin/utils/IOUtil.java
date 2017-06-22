package com.Lin.utils;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/9.
 */
public class IOUtil {
    //从该文件读取byte
    public byte[] getDAT(String path, long fileLength) {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(path));
            byte[] buff = new byte[(int) fileLength];
            int len;
            while ((len = bis.read(buff)) != -1) {
                System.out.println("-----------------------------------");
                System.out.println("文件:" + path + "读出的byte为：" + len);
            }
            return buff;
        } catch (FileNotFoundException e) {
            System.out.printf("文件未找到");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void byte2Pot(byte[] bytes, String tagPath) {
        BufferedOutputStream bof = null;
        try {
            bof = new BufferedOutputStream(new FileOutputStream(tagPath, true));
            bof.write(bytes, 0, bytes.length);
            System.out.println("写入文件成功！");
        } catch (FileNotFoundException e) {
            System.out.println("写入文件无法打开");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("写入失败");
            e.printStackTrace();
        } finally {
            try {
                bof.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void put2File(ArrayList<String> xyList) {
        FileWriter file = null;
        try {
            file = new FileWriter("chapter3" + File.separator + "a.txt");
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < xyList.size(); i++) {
                String str = xyList.get(i);
                if ("-1 0".equals(str)) {
                    continue;
                }
                bw.write(str + "\n");
            }
            System.out.println("写入文件成功！");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void put2File80(ArrayList<String> xyList) {
        FileWriter file = null;
        try {
            file = new FileWriter("chapter3" + File.separator + "a80.txt");
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < xyList.size(); i++) {
                String str = xyList.get(i);
                if ("0 0".equals(str)) {
                    continue;
                }
                bw.write(str + "\n");
            }
            System.out.println("写入文件成功！");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void put2File20(ArrayList<String> xyList) {
        FileWriter file = null;
        try {
            file = new FileWriter("chapter3" + File.separator + "a20.txt");
            BufferedWriter bw = new BufferedWriter(file);
            for (int i = 0; i < xyList.size(); i++) {
                String str = xyList.get(i);
                if ("0 0".equals(str)) {
                    continue;
                }
                bw.write(str + "\n");
            }
            System.out.println("写入文件成功！");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

