package com.info.pattern.thread;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 6:26
 **/
public class Task1 implements Runnable {
    @Override
    public void run() {
        for( int i = 0;i < 10;i ++ ){
            System.out.println("000000..........");
        }
    }
}
