package com.Lin.urtils;


/**
 * Created by Administrator on 2017/6/16.
 */
public class Function_8 {

    public double fanshu(double[] gather1,double[] gather2){
        double fs = 0;
        double f1 = 0;
        double f2 = 0;
        for(int i=0;i<gather1.length;i++){
            f1 += gather1[i]*gather1[i];
        }

        for(int i=0;i<gather2.length;i++){
            f2 += gather2[i]*gather2[i];
        }
        fs = Math.sqrt(f1)*Math.sqrt(f2);
        return fs;
    }

    public double neiji(double[] gather1,double[] gather2){
        float nj = 0;
        for(int i=0;i<gather1.length;i++){
            nj += gather1[i]*gather2[i];
        }
        return nj;
    }

    public double cos(double neiji,double fanshu){
        double cos = 0;
        cos = neiji/fanshu;
        return cos;
    }
}
