package com.mao.exercise01.ReadTxtThread;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunnableImpl implements Runnable {
    //重写run，设置线程任务
    @Override
    public void run() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("E:\\eclipse\\IJworkspace\\allitems\\06_Thread\\src\\com\\mao\\exercise01\\ReadTxtThread\\findall2.txt"));
            String name = "C:\\tmp\\"+Thread.currentThread().getName() + getCurrentTime()+".txt";
            bw = new BufferedWriter(new FileWriter(name));
            //使用特有方法读取
            String line;
            int row=0;
            while ((line = br.readLine()) != null) {
                row++;
                bw.write(line);
                bw.newLine();
            }
            System.out.println("总行数："+row+"......线程名字："+Thread.currentThread().getName());
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if(br!=null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getCurrentTime() {
        Date currentTime = new Date();
        // 日期格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        // 获取系统当前时间
        String dateStr = formatter.format(currentTime);
        return dateStr;
    }
}
