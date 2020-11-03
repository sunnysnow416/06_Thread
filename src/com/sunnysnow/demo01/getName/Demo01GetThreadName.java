package com.sunnysnow.demo01.getName;

/**
 * 主线程名：main
 * 新线程名：Thread-0  ，Thread-1
 */
public class Demo01GetThreadName {
    public static void main(String[] args) {
        //3、创建Thread类的子类对象
        MyThread mt  = new MyThread();
        //4、调用Thread类中的start()方法，开启新的线程，执行线程任务run方法。
        mt.start();   //Thread-0

        new MyThread().start();  //Thread-1


        //主线程获取线程名字
        String mainThreadName = Thread.currentThread().getName();
        System.out.println("main:"+mainThreadName);  //main:main

    }
}
