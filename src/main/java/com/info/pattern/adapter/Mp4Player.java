package com.info.pattern.adapter;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:59
 **/
public class Mp4Player implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
