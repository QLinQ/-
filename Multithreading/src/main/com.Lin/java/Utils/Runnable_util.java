package Utils;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Runnable_util implements Runnable{
    private int i;

    //复写run()方法，run()方法的方法体就是线程的执行体
    public void run(){
        for(; i < 10; i++){
            //当线程实现Runnable接口时
            //想要获取当前线程，只能使用Thread.currentThread()方法
            System.out.println("---Runnable_util---");
            System.out.println("name:"+ Thread.currentThread().getName()+ "\t id:"+ i);
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
