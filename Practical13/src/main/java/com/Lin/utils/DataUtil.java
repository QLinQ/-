package com.Lin.utils;

import com.Lin.bean.*;

import java.util.ArrayList;

/**
 * Created by 14012 on 2017/6/9.
 */
public class DataUtil {
    //全局变量，保存byte[]位置
    public int index=0;
    public int potIndex=0;
    //分析Dat
    public void dealDat(DAT dat,byte[] bytes){
        //1.获取头

        //1.1 获取笔划数
        dat.getHead().setStrokeNumber(byte2Int(bytes));
        System.out.println("笔划数为："+dat.getHead().getStrokeNumber()+",此时index="+index );

        //1.2 获取字符边界
        dat.getHead().setCharSize(forByte2Int(bytes,4));
        int[] charSize = dat.getHead().getCharSize();
        System.out.println("字符边界为："+dat.getHead().charSize2String()+",此时index="+index );

        //1.3 字符编码
        dat.getHead().setCharacter(byte2Int(bytes));
        System.out.println("字符编码为："+dat.getHead().getCharacter()+",此时index="+index );
        //2.获取笔划
            //循环获取各个笔划
            for(int i=0;i<dat.getHead().getStrokeNumber();i++){
                //创建DATStroke对象
                DATStroke datStroke = new DATStroke();
                //2.1 获取笔划包含点数
                datStroke.setPointNumber(byte2Int(bytes));
                System.out.println("笔划包含点数为："+datStroke.getPointNumber()+",此时index="+index);
                //2.2 获取笔划边界
                datStroke.setStrokeBorder(forByte2Int(bytes,4));
                System.out.println("笔划边界为："+datStroke.toStringStrokeBorder()+",此时index="+index);
                //2.3 获取笔划开始时间
                datStroke.setStartTime(byte2Int(bytes));
                System.out.println("笔划开始时间为："+datStroke.getStartTime()+",此时index="+index);
                //2.4 获取笔划结束时间
                datStroke.setEndTime(byte2Int(bytes));
                System.out.println("笔划结束时间为："+datStroke.getEndTime()+",此时index="+index);
                //将datstroke放入dat
                dat.getStroke().add(datStroke);
            }
        //3.获取坐标序列
        //获取所有点数个数
        ArrayList<DATStroke> stroke = dat.getStroke();
        int count = 0;
        for (int i=0;i<stroke.size();i++){
            count += stroke.get(i).getPointNumber();
        }
        for(int i=0;i<count;i++){
            DATXY datxy = new DATXY();
            datxy.setPointXY(forByte2Int(bytes,2));
//            System.out.println("点"+i+"坐标:"+datxy.toStringPointXY()+"，此时index="+index);
            dat.getPointXY().add(datxy);
        }
    }

    //纯获取byte不转换
    private byte[] getBytes(byte[] bytes) {
        byte[] tt = cutByte(bytes, index, 4);
        return tt;
    }
    //循环转换btye2int  count=循环的次数
    private int[] forByte2Int(byte[] bytes,int count) {
        int[] t = new int[count];
        for(int i=0;i<count;i++){
            t[i] = byte2Int(bytes);
        }
        return t;
    }
    //将一段byte转换成int
    private int byte2Int(byte[] bytes) {
        byte[] tt = cutByte(bytes, index, 4);
        return tt[0] & 0xFF |
                (tt[1] & 0xFF) << 8 |
                (tt[2] & 0xFF) << 16 |
                (tt[3] & 0xFF) << 24;
    }

    private short byte2Short(byte[] bytes) {
        return (short) (((bytes[0] & 0xff)) | (bytes[1] & 0xff) << 8);
    }
    //截取byte 参数为：源数组，起始位置，长度
    public byte[] cutByte(byte[] srcByte,int srcPos,int length){
        byte[] tt = new byte[length];
        //截取byte[]
        System.arraycopy(srcByte,srcPos,tt,0,length);
        index += 4;
        return tt;
    }

    public void Dat2Pot(DAT dat, POT pot) {
        //1. 获取头
        //1.2 获取字符编码
        pot.getHead().setCharacter((short) dat.getHead().getCharacter());
        //1.3 获取笔划数
        pot.getHead().setStrokeNumber((short) dat.getHead().getStrokeNumber());
        //2. 获取笔划数据
        //2.1 获取笔划点坐标
        int pointIndex = 0;
        //笔划结束标记
        short[] endSign = new short[2];
        endSign[0] = -1;
        endSign[1] = 0;
        //获取DAT每一个笔划信息
        for (int i=0;i<dat.getStroke().size();i++){
            //获取DAT笔划包含的点数
            int pointNumber = dat.getStroke().get(i).getPointNumber();
            PotSroke potSroke = new PotSroke();
            for (int j=0;j<pointNumber;j++){
                POTXY potxy = new POTXY();
                int[] datPointXY = dat.getPointXY().get(j+pointIndex).getPointXY();
                short[] xy = new short[2];
                xy[0] = (short) datPointXY[0];
                xy[1] = (short) datPointXY[1];
                potxy.setPointXY(xy);
                potSroke.getPointFix().add(potxy);
            }
            //2.2 加入笔划结束
            potSroke.setStrokeEnd(endSign);
            //将笔划数据加入POT
            pot.getStroke().add(potSroke);
            pointIndex += pointNumber;

        }

        //3. 字符结束表示位
        short[] charEndSign = new short[2];
        charEndSign[0] = -1;
        charEndSign[1] = -1;
        //将字符结束标志放入POT
        pot.setEndSign(charEndSign);

        //1.1 获取样本大小
        //样本大小=样本大小（2B）+字符编码（2B）+笔划数(2B)+笔划数个点坐标*4B+笔划个数*4B+字符结束2B
        int count = 2+2+2+2+4*pointIndex+pot.getHead().getStrokeNumber()*4;
        //将样本容量放入POT
        pot.getHead().setYangbenSize((short) count);

    }
    //将pot 转换为byte[]
    public byte[] pot2Pot(POT pot,long fileLength) {
        byte[] potByte = new byte[(int)fileLength];
        byte[] tt = new byte[2];
        //1.放入样本大小
        potByte = short2Byte(pot.getHead().getYangbenSize(),potByte);

        //2.放入字符编码
        potByte = short2Byte(pot.getHead().getCharacter(),potByte);


        //3.放入笔划数
        potByte = short2Byte(pot.getHead().getStrokeNumber(),potByte);

        //4.循环放入笔划数据
        for (int i=0;i<pot.getStroke().size();i++){
            //4.1 放入点坐标
            ArrayList<POTXY> potxyArrayList = pot.getStroke().get(i).getPointFix();
            for (int j=0;j<potxyArrayList.size();j++){
                potByte = short2Byte(potxyArrayList.get(j).getPointXY()[0],potByte);
                potByte = short2Byte(potxyArrayList.get(j).getPointXY()[1],potByte);
            }
            //4.2 放入笔划结束
            potByte = short2Byte(pot.getStroke().get(i).getStrokeEnd()[0],potByte);
            potByte = short2Byte(pot.getStroke().get(i).getStrokeEnd()[1],potByte);

        }
        //5.放入字符结束标志
        potByte = short2Byte(pot.getEndSign()[0],potByte);
        potByte = short2Byte(pot.getEndSign()[1],potByte);

        return potByte;
    }

    //short 转换为 字节数组[2]
    public byte[] short2Byte(short s,byte[] bytes){
        int temp = s;
        byte[] b = new byte[2];
        for (int i = 1; i >=0; i--) {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最高位
            bytes[i+potIndex] = b[i];
            temp = temp >> 8; // 向右移8位
        }
        potIndex += 2;
        return bytes;
    }

    // chapter2
    public byte[] selectCharacter(byte[] srcSetBytes, byte[] srcBytes) {
        // 1. 获取characterA的编码
            byte[] characterBytes = cutByte(srcBytes,2,2);
        //2. 跟set比较
            byte[] resultBytes = compareCharacter(srcSetBytes,characterBytes);

        return resultBytes;
    }

    private byte[] compareCharacter(byte[] srcSetBytes, byte[] characterBytes) {
        int count = 0;
        int i = 0;
        byte[] reslutByte = new byte[srcSetBytes.length];
        while (i<srcSetBytes.length){
            // 1.截取set
            // 1.1 获取每个字符样本的长度
            byte[] bytes = cutByte(srcSetBytes, i, 2);
            short length = byte2Short(bytes);

            //1.2 进行比较
            //获取的编码
            bytes = cutByte(srcSetBytes,i+2,2);
            Boolean result = matherCharacter(characterBytes,bytes);
            if (result){
                count++;
                System.out.println("结果匹配");
                byte[] cutByte = cutByte(srcSetBytes, i, length);
                // 放入result
                int len = reslutByte.length;
                for(int j=0;j<cutByte.length;j++){
                    reslutByte[length+j] = cutByte[j];
                }
            }
            i = i+length;
        }
        System.out.println("一共有"+count+"个编码匹配！");
        return reslutByte;
    }

    private Boolean matherCharacter(byte[] characterBytes, byte[] bytes) {
        for (int i =0 ;i<2 ;i++){
            if (characterBytes[i]!=bytes[i])
                return false;

        }
        return true;
    }


    public ArrayList<String> getXY(byte[] bytes) {
        // 1. 截取字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        int length = bytes.length - 6 - 4;
        byte[] cutBytes = cutByte(bytes, 6, length);
        int i = 0;
        while (i<cutBytes.length){
            byte[] byteX = cutByte(cutBytes, i, 2);
            byte[] byteY = cutByte(cutBytes, i + 2, 2);
            short pointX = byte2Short(byteX);
            short pointY = byte2Short(byteY);
            pointY = (short)(0 - pointY);
            arrayList.add(pointX+" "+pointY);
            i +=4;
        }
        return arrayList;
    }

    public ArrayList<String> getXY80(byte[] bytes) {
        // 1. 截取字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        int length = bytes.length - 6 - 4;
        byte[] cutBytes = cutByte(bytes, 6, length);
        int i = 0;
        while (i<cutBytes.length){
            byte[] byteX = cutByte(cutBytes, i, 2);
            byte[] byteY = cutByte(cutBytes, i + 2, 2);
            short pointX = (short)(byte2Short(byteX)*(80/180.0));
            short pointY = (short)(byte2Short(byteY)*(80/180.0));
            pointY = (short)(0 - pointY);
            arrayList.add(pointX+" "+pointY);
            i +=4;
        }
        return arrayList;
    }

    public ArrayList<String> getXY20(byte[] bytes) {
        // 1. 截取字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        int length = bytes.length - 6 - 4;
        byte[] cutBytes = cutByte(bytes, 6, length);
        int i = 0;
        while (i<cutBytes.length){
            byte[] byteX = cutByte(cutBytes, i, 2);
            byte[] byteY = cutByte(cutBytes, i + 2, 2);
            short pointX = (short)(byte2Short(byteX)*(20/180.0));
            short pointY = (short)(byte2Short(byteY)*(20/180.0));
            pointY = (short)(0 - pointY);
            arrayList.add(pointX+" "+pointY);
            i +=4;
        }
        return arrayList;
    }
}
