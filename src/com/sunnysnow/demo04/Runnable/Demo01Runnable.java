package com.sunnysnow.demo04.Runnable;

/**
 * 创建多线程程序的第二中方法：实现Runnable接口
 *  Java.lang.Runnable
 *      Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现，类必须定义一个成为run的无参方法。
 *  Java.lang.Thread类的构造方法
 *      Thread(Runnable target) 分配新的Thread对象
 *      Thread(Runnable target,String name) 分配新的Thread对象
 * 实现步骤：
 *  1、创建一个Runnable接口的实现类
 *  2、在实现类中重写Runnable接口的run方法，设置线程任务
 *  3、创建一个Runable接口的实现类对象
 *  4、创建Thread对象，构造方法中传递Runnable接口的实现类对象
 *  5、调用Thread类中的start方法，开启新的线程，执行run方法
 *
 *  实现Runnable接口创建多线程的好处：
 *  1、避免了单继承的局限性
 *      一个类只能继承一个类（一个人只能有一个亲爹），类继承了Thread类就不能继承其他类；
 *      实现Runnable接口，还可以继承其他的类，实现其他的接口。
 *  2、增强了程序的扩张性，降低了程序的耦合性（解耦）
 *      实现Runnable接口的方式，把设置线程任务和开启新线程进行了分离（解耦）。
 *      实现类中重写了run方法，设置线程任务，创建Thread类对象，调用start方法，用来开启新的线程
 *
 * ★★ 以后实现多线程，尽量使用实现Runnable接口的方式。
 */
public class Demo01Runnable {
    public static void main(String[] args) {
        //3、创建一个Runable接口的实现类对象
        RunnableImpl run =new RunnableImpl();
        //4、创建Thread对象，构造方法中传递Runnable接口的实现类对象
        //Thread t =new Thread(run);
        Thread t = new Thread(new RunnableImpl2());  //调用不同的实现类，开启不同的线程任务。
        //5、调用Thread类中的start方法，开启新的线程，执行run方法
        t.start();

        //主线程
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }


    }
}
