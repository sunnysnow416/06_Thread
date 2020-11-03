package com.sunnysnow.demo05.InnerClassThread;

/**
 *  匿名内部类的方式实现线程的创建
 *  匿名：没有名字
 *  内部类：写在其他类内部的类
 *  匿名内部类：简化代码
 *      把子类继承父类，重写父类的方法，创建子类对象合一步完成。
 *      把实现类实现接口重写接口中的方法，创建实现类对象合一步完成。
 *  匿名内部类的最终产物：子类/实现类队形，而这个类没有名字
 *
 *  格式:
 *      new 父类/接口(){
 *          重写父类/接口中的方法
 *      };
 */
public class Demo01InnerClassThread {
    public static void main(String[] args) {
        //线程的父类是Thread
        new Thread(){
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+"-->"+"方法");
                }
            }
        }.start();


        //线程的接口Runnable接口
        Runnable r = new Runnable() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + "接口");
                }
            }
        };
        new Thread(r).start();


        //简化接口的方式
        new Thread(new Runnable() {
            //重写run方法，设置线程任务
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + "-->" + "接口2");
                }
            }
        }).start();

    }
}
