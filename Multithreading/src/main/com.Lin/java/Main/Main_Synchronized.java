package Main;

import Stractclass.Stract_Synchronized;
import Utils.Synchronized_util;

/**
 * Created by Administrator on 2017/6/22.
 */
public class Main_Synchronized {
    public static void main(String[] args) {
        Stract_Synchronized ssc = new Stract_Synchronized("123",1000);

        new Synchronized_util("甲",ssc,800).start();
        new Synchronized_util("已",ssc,800).start();
    }
}
