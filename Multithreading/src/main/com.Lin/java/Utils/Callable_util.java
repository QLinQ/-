package Utils;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2017/6/21.
 */
public class Callable_util implements Callable{
    private int i;

    public Integer call(){
        for(; i<10; i++){
            System.out.println("---Callable_util---");
            System.out.println("name:"+ Thread.currentThread().getName()+ "\t id:"+ i);
            try {
                Thread.sleep(1000);//睡眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("睡眠1秒结束！");
            }
        }
        return i;
    }
}
