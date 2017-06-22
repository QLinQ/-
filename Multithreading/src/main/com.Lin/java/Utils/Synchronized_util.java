package Utils;

import Stractclass.Stract_Synchronized;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Synchronized_util extends Thread {
    private Stract_Synchronized account;
    private double drawAmount;

    public Synchronized_util(String name, Stract_Synchronized account, double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        System.out.println("---Thread_util---");
        synchronized (account) {
            if (account.getBalance() >= drawAmount) {
                System.out.println(getName() + "成功取出：" + drawAmount + "￥");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("\t余额为：" + account.getBalance());
            } else {
                System.out.println(getName() + "取款失败！余额不足！");
            }
        }
    }
}
