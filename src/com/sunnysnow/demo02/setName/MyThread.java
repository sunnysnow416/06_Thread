package com.sunnysnow.demo02.setName;

/**
 * 设置线程的名称（了解即可）两种方式：
 *      1、使用Thread类中的方法setName(名字)
 *          void setName(String name) 改变线程名称，使之与参数name相同
 *      2、创建一个带参数的构造方法，参数传递线程名称，调用父类的带参构造方法，把线程名称传递给父类。让父类（Thread）给子类起一个名称
 *          Thread（String name) 分配新的Thread对象
 */
public class MyThread  extends Thread{
    //空参数的构造方法
    public MyThread(){};
    //方法二：带参数的构造方法
    public MyThread(String name){
        super(name);
    }


    //方法一
    @Override
    public void run() {
        //方法一：
        System.out.println(Thread.currentThread().getName());
    }
}
