package com.sunnysnow.demo12.ThreadPool;

public class RunnableImpl implements Runnable{
    //2、创建一个类实现Runnable接口，重写run方法，设置线程任务
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新多线程");
    }
}
