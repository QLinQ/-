package com.Lin.bean;

/**
 * Created by 14012 on 2017/6/9.
 */
public class DATStroke {
    //包含点数
    private int pointNumber;
    //笔划边界
    private int[] strokeBorder = new int[4];
    //笔划开始时间
    private int startTime;
    //笔划结束时间
    private int endTime;

    public int getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(int pointNumber) {
        this.pointNumber = pointNumber;
    }

    public int[] getStrokeBorder() {
        return strokeBorder;
    }

    public void setStrokeBorder(int[] strokeBorder) {
        this.strokeBorder = strokeBorder;
    }

    public String toStringStrokeBorder(){
        return strokeBorder[0]+","+strokeBorder[1]+","+strokeBorder[2]+","+strokeBorder[3];
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
