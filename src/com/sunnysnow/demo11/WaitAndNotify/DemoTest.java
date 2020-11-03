package com.sunnysnow.demo11.WaitAndNotify;
public class DemoTest {
    public static void main(String[] args) {
        //包子对象
        BaoZi bz = new BaoZi();
        //包子铺线程
        new BaoZiPu(bz).start();
        //吃货线程
        new ChiHuo(bz).start();
    }
}
