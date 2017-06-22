package com.Lin.main;

import com.Lin.urtils.Function_8;

/**
 * Created by Administrator on 2017/6/16.
 */
public class Practical14_8 {
    public static void main(String[] args) {
        Function_8 fun = new Function_8();
        double[] p = {1,2,3,4,5,6,7,8,9};
        double[] t = {9,8,7,6,5,4,3,2,1};

        double fanshu_pt = fun.fanshu(p,t);
        double neiji_pt = fun.neiji(p,t);
        double cos_pt = fun.cos(neiji_pt,fanshu_pt);

        System.out.println(cos_pt);

    }
}
