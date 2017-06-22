package Main;

import Utils.Runnable_util;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Main_Runnable {
    public static void main(String[] args) {
        for(int i=0 ;i < 10 ;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println("---Main---");
            System.out.println("name:"+ Thread.currentThread().getName()+ "\tid:"+ i);
            if(i == 2 ){
                //实现Runnable接口，必须先实例化实现接口的类对象
                //然后利用new Thread(对象，线程名)或者直接 new Thread(对象)实现进程创建
                Runnable_util ru = new Runnable_util();
                new Thread(ru, "Runnable-1").start();
                new Thread(ru, "Runnable-2").start();
            }
            try {
                Thread.sleep(1000);//睡眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("睡眠1秒结束！");
            }
        }
    }
}
