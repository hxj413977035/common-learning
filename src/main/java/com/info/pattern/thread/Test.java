package com.info.pattern.thread;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 6:28
 **/
public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task1());

        thread2.start();
        thread1.start();
    }

}
