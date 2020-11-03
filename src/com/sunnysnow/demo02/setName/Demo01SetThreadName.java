package com.sunnysnow.demo02.setName;

public class Demo01SetThreadName {
    public static void main(String[] args) {
        //方法一：
        MyThread mt = new MyThread();
        mt.setName("新线程名张三");
        mt.start();

        //方法二：
        MyThread mt2 = new MyThread("新线程名李四");
        mt2.start();
    }
}
