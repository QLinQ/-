package Main;

import Utils.Callable_util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Main_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建Callable对象
        Callable_util cu = new Callable_util();
        //使用FutureTask来包装Callable类
        FutureTask<Integer> futask = new FutureTask<Integer>(cu);
        for(int i=0 ;i < 10 ;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println("---Main---");
            System.out.println("name:"+ Thread.currentThread().getName()+ "\tid:"+ i);
            if(i == 2 ){
                //实现Runnable接口，必须先实例化实现接口的类对象
                //然后利用new Thread(对象，线程名)或者直接 new Thread(对象)实现进程创建
                new Thread(futask,"带返回值的线程").start();
                System.out.println("返回值：" + futask.get());
            }
            try {
                Thread.sleep(1000);//睡眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("睡眠1秒结束！");
            }
        }
    }
}
