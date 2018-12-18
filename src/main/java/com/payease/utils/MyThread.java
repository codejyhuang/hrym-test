package com.payease.utils;

import java.net.ServerSocket;
import java.util.regex.Matcher;

/**
 * Created by hrym13 on 2018/6/20.
 */

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            int time = (int)  (Math.random()*1000);
            try {
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("pppp");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }

}
