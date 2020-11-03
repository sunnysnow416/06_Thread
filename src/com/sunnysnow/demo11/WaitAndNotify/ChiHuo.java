package com.sunnysnow.demo11.WaitAndNotify;

/*
    消费者（吃货）类：是一个线程类，继承Thread
    设置线程任务（run）:吃包子
    对包子的状态进行判断：
    false：没有包子
        吃货调用wait方法，进入等待状态
    true：有包子
        吃货吃包子
        吃货吃完包子
        修改包子的状态为faslse没有
        吃货唤醒包子铺线程，生产包子
 */
public class ChiHuo extends Thread {
    //1、在成员位置创建包子变量
    private BaoZi bz;

    //2、使用带参数的构造方法，为包子变量赋值
    public ChiHuo(BaoZi bz){
        this.bz=bz;
    }

    //设置线程任务（run）:吃包子
    @Override
    public void run() {
        while (true){
            //必须使用同步技术保证两个线程只有一个在执行
            synchronized (bz){
                if(bz.flag==false){
                    // 吃货调用wait方法，进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒之后执行，吃货吃包子
                System.out.println("吃货正在吃"+bz.Pi+bz.xian+"的包子");
                //吃货吃完包子
                //修改包子的状态为faslse没有
                bz.flag=false;
                //吃货唤醒包子铺线程，生产包子
                bz.notify();
                System.out.println("吃货已经把"+bz.Pi+bz.xian+"的包子吃完了，包子铺可以开始生产包子了");
                System.out.println("===============================");
            }
        }
    }
}
