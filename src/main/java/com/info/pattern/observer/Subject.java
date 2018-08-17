package com.info.pattern.observer;

/**
 * @Description: 观察者模式demo
 * @Author Administrator
 * @CreateTime 2018-08-17 下午 2:19
 **/
public interface Subject {

    /**
     * 注册观察者
     *
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有观察者
     */
    void notifyObservers();
}
