package com.Lin.bean;

/**
 * Created by 14012 on 2017/6/9.
 */
public class DATXY {
    public int[] pointXY = new int[2];

    public int[] getPointXY() {
        return pointXY;
    }

    public void setPointXY(int[] pointXY) {
        this.pointXY = pointXY;
    }

    public String toStringPointXY(){
        return pointXY[0]+","+pointXY[1];
    }
}
