package Main;

import Utils.Thread_util;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Main_Thread {
    public static void main(String[] args) {
        for(int i=0 ;i < 10 ;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println("---Main---");
            System.out.println("name:"+ Thread.currentThread().getName()+ "\tid:"+ i);
            if(i == 2 ){
                //创建第一个线程，并启动
                new Thread_util().start();
                //创建第二个线程，并启动
                new Thread_util().start();
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
