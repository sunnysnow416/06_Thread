package com.mao.exercise01.ReadTxtThread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 参考地址：
 * https://blog.csdn.net/supperdoof/article/details/78687570
 */
public class Test01 {
    public static void main(String[] args) throws IOException {

        //1、使用线程池的工厂类Executors里边提供的静态方法生产一个指定数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3、调用ExecutorService中的方法submit，传递线程任务（实现类），开启线程，执行run方法。
        es.submit(new RunnableImpl());
        //线程池会一直开着，使用完了，会硅烷给线程池，线程可以继续使用
        es.submit(new RunnableImpl());
    }
}
