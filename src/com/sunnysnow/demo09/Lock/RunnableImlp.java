package com.sunnysnow.demo09.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
    卖票案例出现了线程安全问题：卖出了重复的票和不存在的票
    第三种方法：锁机制

    java.util.concurrent.locks.lock接口
    lock实现提供了比使用synchronized方法和语句可获得的更广泛的锁定操作。
    lock接口中的方法：
        void lock() 获取锁
        void unLock() 释放锁
        java.util.concurrent.locks.reentrantLock implements Lock接口
    使用步骤：
    1、成员位置创建一个reentrantLock对象
    2、在可能会出现安全问题的代码前，调用lock接口中的方法lock获取锁
    3、在可能会出现安全问题的代码后，调用lock接口中的方法unLock释放锁
 */
public class RunnableImlp implements Runnable {
    //定义多个线程共享的票源
    private int ticket =10;
    //1、成员位置创建一个reentrantLock对象
    Lock l = new ReentrantLock();//多态

    //设置线程任务，目的卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            //2、在可能会出现安全问题的代码前，调用lock接口中的方法lock获取锁
            l.lock();
            if(ticket>0){
                try {
                    //为了提高线程问题出现的频率
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //3、在可能会出现安全问题的代码后，调用lock接口中的方法unLock释放锁
                    //无论是否程序异常都会释放锁，提高效率
                    l.unlock();
                }
            }

        }
    }

/**
    //设置线程任务，目的卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            //2、在可能会出现安全问题的代码前，调用lock接口中的方法lock获取锁
            l.lock();
            if(ticket>0){
                try {
                    //为了提高线程问题出现的频率
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                ticket--;
            }
            //3、在可能会出现安全问题的代码后，调用lock接口中的方法unLock释放锁
            l.unlock();
        }
    }
    */
}
