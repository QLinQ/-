package com.Lin.bean;

/**
 * Created by 14012 on 2017/6/9.
 */
public class POTHead  {
    //样本大小
    private short yangbenSize;
    //字符编码
    private short character;
    //笔划数
    private short strokeNumber;

    public short getYangbenSize() {
        return yangbenSize;
    }

    public void setYangbenSize(short yangbenSize) {
        this.yangbenSize = yangbenSize;
    }

    public short getCharacter() {
        return character;
    }

    public void setCharacter(short character) {
        this.character = character;
    }

    public short getStrokeNumber() {
        return strokeNumber;
    }

    public void setStrokeNumber(short strokeNumber) {
        this.strokeNumber = strokeNumber;
    }
}
