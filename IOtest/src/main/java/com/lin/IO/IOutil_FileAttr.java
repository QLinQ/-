package com.lin.IO;

import com.lin.structclass.FileAttribute;

import java.io.File;
import java.util.*;

/**
 * Created by Administrator on 2017/6/19.
 */
public class IOutil_FileAttr {

    //存储File对象所有文件的FileAttribute对象
    ArrayList<FileAttribute> fa_list = new ArrayList<FileAttribute>();

    public ArrayList<FileAttribute> recognition(String path){
        //利用用户设置的path创建File对象
        File fi = new File(path);
        //存储单个FileAttribute对象的属性

        if (fi.exists()) {
            FileAttribute fa_1 = new FileAttribute(1,fi.getName(),fi.getAbsolutePath(),fi.list());
            fa_list.add(fa_1);

            File[] files = fi.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        recognition(file2.getAbsolutePath());
                    } else {
                        FileAttribute fa_2 = new FileAttribute(0,file2.getName(),file2.getAbsolutePath());
                        fa_list.add(fa_2);
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
        return fa_list;
    }

    public HashMap<String,String> filemap(ArrayList<FileAttribute> fa_list) {
        HashMap<String, String> mp = new HashMap<String, String>();

        for(FileAttribute fa : fa_list){
            if(fa.getFilenature() == 0){
                mp.put(fa.getFilename(),fa.getFilepath());
            }
        }

        return mp;
    }

    public void standardoutput(ArrayList<FileAttribute> list){
        for(FileAttribute fa : list){
            if(fa.getFilenature() == 1){
                System.out.println("目录："+fa.getFilepath());
            }else{
                System.out.println("--文件："+fa.getFilename());
            }
        }
    }

    public void standardoutput(HashMap<String,String> mp){
        Iterator iter = mp.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            System.out.println(key+"\t|\t"+val);
        }
    }

}
