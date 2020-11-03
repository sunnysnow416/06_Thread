package com.sunnysnow.demo06.ThreadSafe;

/*
    目的：实现卖票案例
 */
public class RunnableImlp implements Runnable {
    //定义多个线程共享的票源
    private int ticket =10;
    //设置线程任务，目的卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            if(ticket>0){
                try {
                    //为了提高线程问题出现的频率
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"-->正在卖第"+ticket+"张票");
                ticket--;
            }
        }
    }
}
