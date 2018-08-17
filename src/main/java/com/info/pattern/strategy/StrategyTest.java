package com.info.pattern.strategy;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:36
 **/
public class StrategyTest {

    public static void main(String[] args) {
        Context context = new Context(new Operate1());
        context.doOperate("张三");

        context = new Context(new Operate2());
        context.doOperate("李四");
    }
}
