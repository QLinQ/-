package com.Lin.bean;

/**
 * Created by 14012 on 2017/6/9.
 */
public class DATHead {
    //笔划数
    private int strokeNumber;
    //字符边界
    private int[] charSize = new int[4];
    //字符编码
    private int character;

    public int getStrokeNumber() {
        return strokeNumber;
    }

    public void setStrokeNumber(int strokeNumber) {
        this.strokeNumber = strokeNumber;
    }

    public int[] getCharSize() {
        return charSize;
    }
    public String charSize2String(){
        return charSize[0]+","+charSize[1]+","+charSize[2]+","+charSize[3];
    }

    public void setCharSize(int[] charSize) {
        this.charSize = charSize;
    }

    public int getCharacter() {
        return character;
    }

    public void setCharacter(int character) {
        this.character = character;
    }
}
