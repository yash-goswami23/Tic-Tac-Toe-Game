package com.example.tictactoe;


import android.content.Context;
import android.media.MediaPlayer;

public class sounds {

    Context context;
    MediaPlayer bgSound;
    MediaPlayer overSound;

    public MediaPlayer getOverSound() {
        overSound = MediaPlayer.create(context,R.raw.gameoversound);
        return overSound;
    }

    public void setOverSound(MediaPlayer overSound) {
        this.overSound = overSound;
    }

    public MediaPlayer getWinSound() {
        winSound = MediaPlayer.create(context,R.raw.winsound);
        return winSound;
    }

    public void setWinSound(MediaPlayer winSound) {
        this.winSound = winSound;
    }

    MediaPlayer winSound;
    MediaPlayer clickSound;

    public MediaPlayer getBgSound() {
        return bgSound;
    }
    public MediaPlayer getClickSound() {
        return clickSound;
    }

    public void setClickSound(MediaPlayer clickSound) {
        clickSound = MediaPlayer.create(context,R.raw.tapsound);
        this.clickSound = clickSound;
    }


    sounds(Context context){
        this.context = context;
    }
    public void setBgSound(MediaPlayer bgSound) {
        bgSound = MediaPlayer.create(context,R.raw.backgroundmusic);
        this.bgSound = bgSound;
    }


}
