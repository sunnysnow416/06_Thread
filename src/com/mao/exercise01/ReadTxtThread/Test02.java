package com.mao.exercise01.ReadTxtThread;

import java.util.ArrayList;
import java.util.List;

public class Test02 {
    public static void main(String[] args) {
        //3、创建一个Runable接口的实现类对象
        RunnableImpl run = new RunnableImpl();
        //4、创建Thread对象，构造方法中传递Runnable接口的实现类对象

        List<Thread> list = new ArrayList<>();
        while (list.size()<5){
                new Thread(new RunnableImpl()).start();
        }
    }
}
