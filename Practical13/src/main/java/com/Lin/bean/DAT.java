package com.Lin.bean;

import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/9.
 */
public class DAT {
    //头
    private DATHead head = new DATHead();
    //笔划信息
    private ArrayList<DATStroke> stroke = new ArrayList<DATStroke>();
    //坐标序列
    private ArrayList<DATXY> pointXY = new ArrayList<DATXY>();

    public DATHead getHead() {
        return head;
    }

    public void setHead(DATHead head) {
        this.head = head;
    }

    public ArrayList<DATStroke> getStroke() {
        return stroke;
    }

    public void setStroke(ArrayList<DATStroke> stroke) {
        this.stroke = stroke;
    }

    public ArrayList<DATXY> getPointXY() {
        return pointXY;
    }

    public void setPointXY(ArrayList<DATXY> pointXY) {
        this.pointXY = pointXY;
    }
}
