package Stractclass;

/**
 * Created by Administrator on 2017/6/21.
 * 假设的银行账户记录类
 */
public class Stract_Synchronized {
    private String accountNo;
    private double balance;

    public Stract_Synchronized(){}
    public Stract_Synchronized(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if ((this != null) && (obj.getClass() == Stract_Synchronized.class)) {
            Stract_Synchronized target = (Stract_Synchronized) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
