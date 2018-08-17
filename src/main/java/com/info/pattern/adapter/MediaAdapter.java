package com.info.pattern.adapter;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 3:59
 **/
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (type.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String type, String name) {
        if (type.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(name);
        } else if (type.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(name);
        }
    }
}
