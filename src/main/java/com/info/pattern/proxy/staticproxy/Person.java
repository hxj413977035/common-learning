package com.info.pattern.proxy.staticproxy;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-14 下午 6:13
 **/
public class Person implements IPerson {

    @Override
    public void sleep() {
        System.out.println("睡觉中");
    }

    @Override
    public void eating() {
        System.out.println("正在吃饭中");
    }

}
