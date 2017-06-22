package com.lin.structclass;


import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/19.
 */
public class FileAttribute {
    private String filename="";//文件名
    private String filepath="";//文件绝对路径
    private int filenature = 0;//判断是否为文件：0为文件、1为目录
    private String[] pathlist = new String[]{};//存储目录的子文件列表

    public FileAttribute(int nature ,String name, String path){
        this.filenature = nature;
        this.filename = name;
        this.filepath = path;
    }

    public FileAttribute(int nature ,String name, String path, String[] list){
        this.filenature = nature;
        this.filename = name;
        this.filepath = path;
        this.pathlist = list;
    }

    public String getFilename() {
        return filename;
    }

    public String getFilepath() {
        return filepath;
    }

    public int getFilenature() {
        return filenature;
    }

    public String[] getPathlist() {
        return pathlist;
    }
}
