package com.info.pattern.observer;

/**
 * @Description: 所有观察者都需要实现该接口
 * @Author Administrator
 * @CreateTime 2018-08-17 下午 2:21
 **/
public interface Observer {

    void update(String msg);
}
