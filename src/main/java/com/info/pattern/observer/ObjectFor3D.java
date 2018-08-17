package com.info.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-17 下午 2:22
 **/
public class ObjectFor3D implements Subject {

    List<com.info.pattern.observer.Observer> observers = new ArrayList<>(16);

    private String msg;

    @Override
    public void registerObserver(com.info.pattern.observer.Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(com.info.pattern.observer.Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(msg));
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }
}
