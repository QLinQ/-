package com.Lin.bean;

import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/9.
 */
public class POT {
    //头
    private POTHead head = new POTHead();
    //笔划数据
    private ArrayList<PotSroke> stroke = new ArrayList<PotSroke>();
    //字符结束标志
    private short[] endSign = new short[2];

    public POTHead getHead() {
        return head;
    }

    public void setHead(POTHead head) {
        this.head = head;
    }

    public ArrayList<PotSroke> getStroke() {
        return stroke;
    }

    public void setStroke(ArrayList<PotSroke> stroke) {
        this.stroke = stroke;
    }

    public short[] getEndSign() {
        return endSign;
    }

    public void setEndSign(short[] endSign) {
        this.endSign = endSign;
    }
}
