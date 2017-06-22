package Utils;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Thread_util extends Thread {
    private int i;

    //复写run()方法，run()方法的方法体就是线程的执行体
    public void run(){
        for(; i < 10; i++){
            //当线程继承Thread类时，直接使用this就可以获取当前线程
            //Thread对象的getName()方法返回当前线程的名称
            //综上，可以直接调用getName()方法返回当前线程的名字
            System.out.println("---Thread_util---");
            System.out.println("name:"+ getName()+ "\t id:"+ i);
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
