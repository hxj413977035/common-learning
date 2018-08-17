package com.info.pattern.observer.JavaObservable;

import java.util.Observable;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-17 下午 2:39
 **/
public class SubjectForSSQ extends Observable {
    private String msg;


    public String getMsg() {
        return msg;
    }


    /**
     * 主题更新消息
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers();
    }
}
