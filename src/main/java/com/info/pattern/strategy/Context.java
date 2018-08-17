package com.info.pattern.strategy;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:33
 **/
public class Context {

    private MyStrategy myStrategy;

    public Context(MyStrategy myStrategy) {
        this.myStrategy = myStrategy;
    }

    public void doOperate(String name) {
        myStrategy.execute(name);
    }
}
