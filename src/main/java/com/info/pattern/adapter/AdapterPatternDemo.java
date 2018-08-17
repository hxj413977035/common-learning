package com.info.pattern.adapter;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-07-03 下午 4:23
 **/
public class AdapterPatternDemo {

    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3","mp3文件");
        player.play("mp4","mp4文件");
        player.play("vlc","vlc文件");
        player.play("avi","avi文件");
    }

}
