package com.sunnysnow.demo08.Sychronized;

/*
    卖票案例出现了线程安全问题：卖出了重复的票和不存在的票
    第二种方法：同步方法
    步骤：
        1、把访问了共享数据的代码抽取出来放到一个方法中
        2、给方法添加synchronized修饰符
    格式：定义方法的格式
    修饰符 synchronized 返回值类型 方法名(参数名){
        访问了共享数据的代码
    }
 */
public class RunnableImlp implements Runnable {
    //定义多个线程共享的票源
    private static int ticket =10;
    //设置线程任务，目的卖票
    @Override
    public void run() {
        //让卖票重复执行
        while (true){
            payTicket();
//            payTicketStatic();
        }
    }

    /**
     * 定义一个同步方法
     * 同步方法也会把方法内的代码锁住
     * 只让一个线程执行
     * 同步方法的锁对象，是实现类对象 new RunRunnableImlp()
     * 也就是this
     */
    public  synchronized  void payTicket(){
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

    /**
     * 同上面的方法
     */
    public /*synchronized*/ void payTicket2(){
        synchronized (this){
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

    /**
     *  静态同步方法:了解即可
     *  锁对象是：
     *  不能是this，因为this是创建对象之后产生的，静态方法优先于对象
     *  静态方法的锁对象是本类的class属性-->class文件对象（反射）
     *
     */
    public static synchronized void payTicketStatic(){
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

    /**
     * 同上面的方法
     */
    public static /*synchronized*/ void payTicketStatic2(){
        synchronized (RunnableImlp.class){
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
