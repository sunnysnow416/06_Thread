package com.sunnysnow.demo09.Lock;

/*
        线程安全问题，模拟卖票案例
        创建3个线程，同时开启，对共享的票进行出售
        结果问题：
        1、出现两个线程同时卖第100张票
        2、出现卖第0张票
        3、出现卖第1张票
 */
public class Demo01Ticket {
    public static void main(String[] args) {
        RunnableImlp r =new RunnableImlp();
        Thread t0 = new Thread(r);
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t0.start();
        t1.start();
        t2.start();

    }


}
