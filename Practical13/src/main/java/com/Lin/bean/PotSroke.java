package com.Lin.bean;

import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/9.
 */
public class PotSroke{
    //点坐标（x,y）
    private ArrayList<POTXY> pointFix = new ArrayList<POTXY>();
    //笔划结束
    private short[] strokeEnd = new short[2];

    public ArrayList<POTXY> getPointFix() {
        return pointFix;
    }

    public void setPointFix(ArrayList<POTXY> pointFix) {
        this.pointFix = pointFix;
    }

    public short[] getStrokeEnd() {
        return strokeEnd;
    }

    public void setStrokeEnd(short[] strokeEnd) {
        this.strokeEnd = strokeEnd;
    }
}
