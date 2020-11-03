package com.sunnysnow.demo12.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    线程池：jdk1.5后提供
    java.util.concurrent.Executors:线程池的工厂类，用来生成线程池
    Executors类中的静态方法:
        static ExectorService newFixedThreadPool(int nThreads)
        参数：
            int nThreads:线程池中包含线程的数量
        返回值：
            ExectorService 接口，返回的是ExectorService接口的实现类对象，我们可以使用ExectorService接口来接收。

    java.util.confurrent.ExecutorService:线程池接口
        用来从线程池中获取线程，调用start方法执行线程任务
        submit(Runnable task) 提交一个Runnable任务用于执行

        关闭销毁线程池 void shutDown()

    线程池的使用步骤：
    1、使用线程池的工厂类Executors里边提供的静态方法生产一个指定数量的线程池
    2、创建一个类实现Runnable接口，重写run方法，设置线程任务
    3、调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法。
    4、调用ExecutorService中的方法shutDown销毁线程池（一般不建议执行）。
 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1、使用线程池的工厂类Executors里边提供的静态方法生产一个指定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3、调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法。
        es.submit(new RunnableImpl());
        //线程池会一直开着，使用完了，会硅烷给线程池，线程可以继续使用
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());

        //关闭线程池，不建议执行
        //es.shutdown();

    }
}
