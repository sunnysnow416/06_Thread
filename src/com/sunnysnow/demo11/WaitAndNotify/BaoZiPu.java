package com.sunnysnow.demo11.WaitAndNotify;

/*
    生产者类：是一个线程类，集成Thread
    设置线程任务：生成包子
    对包子的状态进行判断
    true：有包子
        包子铺使用wait方法进入等待状态
    false：没有包子
        包子铺生产包子
        增加一些趣味性：交替生产两种包子
            有两种状态（i%2==0）
        包子铺生产好了包子
        修改包子的状态为true有
        唤醒吃货线程，让吃货吃包子

    注意：
        1、包子铺线程和吃货线程是通信关系（互斥关系）
        必须使用同步技术保证两个线程只有一个在执行
        锁对象必须保证唯一，可以使用包子对象作为锁对象
        包子铺类和吃货类需要把包子对象作为参数传递进来
            1、在成员位置创建包子变量
            2、使用带参数的构造方法，为包子变量赋值
 */
public class BaoZiPu extends Thread {
    //1、在成员位置创建包子变量
    private BaoZi bz;

    //2、使用带参数的构造方法，为包子变量赋值
    public BaoZiPu(BaoZi bz){
        this.bz=bz;
    }


    //设置线程任务，生成包子
    @Override
    public void run() {
        //定义一个变量
        int count=0;
        //必须使用同步技术保证两个线程只有一个在执行
        while (true){
            synchronized (bz){
                //对包子的状态进行判断
                if(bz.flag==true){
                    //包子铺使用wait方法进入等待状态
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被唤醒之后执行，包子铺生产包子
                //增加一些趣味性：交替生产两种包子
                if(count%2==0){
                    System.out.println("包子铺生产薄皮豆沙馅包子");
                    bz.Pi="薄皮";
                    bz.xian="豆沙馅";
                }else{
                    System.out.println("包子铺生产冰皮牛肉馅包子");
                    bz.Pi="冰皮";
                    bz.xian="牛肉馅";
                }
                count++;
                System.out.println("包子铺长在生产："+bz.Pi+bz.xian+"的包子");
                //生成包子需要3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //生产好了包子，改状态为true
                bz.flag=true;
                //唤醒吃货线程，让吃货吃包子
                bz.notify();
                System.out.println("包子铺已经生产好了"+bz.Pi+bz.xian+"包子,吃货可以开始吃了");
            }
        }

    }
}
