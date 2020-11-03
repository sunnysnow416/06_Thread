package com.mao.exercise01.ReadTxtThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class RunnableImpl implements Runnable {
    //重写run，设置线程任务
    @Override
    public void run() {

    }


    public String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
