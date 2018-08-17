package com.info.pattern.adapter;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:58
 **/
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
