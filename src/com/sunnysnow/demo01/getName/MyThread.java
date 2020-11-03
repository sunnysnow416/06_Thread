package com.sunnysnow.demo01.getName;

/**
 * 获取线程的名称：
 * 1、使用Thread类中的方法getName()
 * 2、可以先获取到当前正在执行的线程，在用线程中的方法getName()获取线程的名称
 *      static currentThread() 返回当前站在执行的线程对象的引用。
 */

//1、创建Thread类的子类,基础Thread类
public class MyThread extends Thread{
    //2、在Thread类的子类中重写run方法，设置线程任务
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
