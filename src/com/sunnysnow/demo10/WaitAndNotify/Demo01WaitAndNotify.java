package com.sunnysnow.demo10.WaitAndNotify;

import jdk.nashorn.internal.ir.WhileNode;

/*
    等待唤醒案例：线程之间的通信
        创建一个顾客（消费者），告知老板包子的种类和数量，调用wait方法，放弃cpu的执行，进入到waitting状态（无限等待）
        创建一个老板（生产者），花了3秒做包子，做好包子之后，调用notify方法唤醒顾客吃包子
    注意：
        1、顾客和老板线程，必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行。
        同步使用的锁对象必须是唯一的，只有锁对象才能调用wait和notify方法

        Object类中
        void wait() 在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待；
        void notify() 唤醒在此对象监视器上等待的单个线程。会继续执行wait方法之后的代码。

 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object object = new Object();

        //使用匿名内部类，创建顾客线程
        new Thread(){
            @Override
            public void run() {
                while (true){
                    //保证等待和唤醒的线程只能有一个执行，需要使用同步技术
                    synchronized (object){
                        System.out.println("告知老板包子的种类和数量");
                        //调用wait方法，放弃cpu的执行，进入到waitting状态（无限等待）
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //唤醒之后执行的代码
                    System.out.println("包子已经做好了，开吃！");
                }
            }
        }.start();

        //创建老板线程
        new Thread(){

            @Override
            public void run() {
                while (true){
                    //花了3秒做包子
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (object){
                        System.out.println("花了3秒做包子，做好包子之后告知顾客可以吃包子");
                        object.notify();
                    }
                }
            }
        }.start();
    }
}
