package com.info.pattern.strategy;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:31
 **/
public class Operate1 implements MyStrategy {
    @Override
    public void execute(String name) {
        System.out.println("hi," + name + ",this is Operate1 implements....");
    }
}
