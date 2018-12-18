package com.payease.test;


import java.util.*;

/**
 * Created by hrym13 on 2018/7/16.
 */
public class Test {

    public void sayHello() {
        System.out.println("sayHello");
    }
//    public aspect


/**
 * try {}里有一个return语句，那么紧跟在这个try后的finally {}里的code会不会被执行，什么时候被执行，还是在return之后执行？
 * @author Hongten
 * @date 2013-12-10
 */

            public static void main(String[] args) {

                long num = 100 ;
                int x = (int) num + 2 ;
                System.out.println(x) ;
            }

            static int test(){
                int i = 1;
                try {
                    System.out.println("try里面的i : " + i);
                    return i;
                }finally{
                    System.out.println("进入finally...");
                    ++i;
                    System.out.println("fianlly里面的i : " + i);
                }
            }


}
