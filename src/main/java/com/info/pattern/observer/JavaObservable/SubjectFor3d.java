package com.info.pattern.observer.JavaObservable;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-17 下午 2:37
 **/
public class SubjectFor3d extends Observable {

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
