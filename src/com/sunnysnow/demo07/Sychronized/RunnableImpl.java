package com.sunnysnow.demo07.Sychronized;

import com.sunnysnow.demo06.ThreadSafe.RunnableImlp;

/**
 *  卖票案例出现了线程安全问题：卖出了重复的票和不存在的票
 *
 *  使用线程同步技术解决线程安全问题，有三种方式
 *      1、同步代码块
 *      2、同步方法
 *      3、锁机制
 *
 *  此处介绍第一种方法：同步代码块
 *  格式：
 *   synchronized(锁对象){
 *       可能会出现线程安全问题的代码（访问了共享数据的代码）
 *   }
 *   注意：
 *      1、通过代码块中的锁对象，可以是任意的对象
 *      2、但是必须保证多个线程使用的锁对象是同一个
 *      3、锁对象可以把同步代码块锁住，只让一个线程再同步代码块中执行
 */
public class RunnableImpl implements Runnable {
    private  int ticket =10;
    //创建一个锁对象
    Object obj =new Object();

    //从写run方法，设置线程任务
    @Override
    public void run() {
        while (true){
            //同步代码块
            synchronized (obj){
                if(ticket>0){
                    try {
                        //为了提高线程问题出现的频率
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //票存在，卖票
                    System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }
    }
}
