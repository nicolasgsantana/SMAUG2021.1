package com.neterusgames.tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {

    private final Music music;

    public MusicPlayer(){
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu-music.ogg"));
    }

    public void playMusic(){
        if(!(music.isPlaying())){
            music.setVolume(0.5f);
            music.setLooping(true);
            music.play();
        }
    }

    public void dispose(){
        music.dispose();
    }

}
