package com.payease.utils;

/**
 * Created by hrym13 on 2018/7/12.
 */
public class Run {
    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        Thread.currentThread().setName("MyThread");
        myThread.start();

        for (int i = 0;i<10;i++){
            int time = (int) (Math.random()*1000);
            try {
                Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程结束！");
    }
}
