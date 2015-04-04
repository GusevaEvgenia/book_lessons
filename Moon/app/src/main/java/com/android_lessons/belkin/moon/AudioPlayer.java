package com.android_lessons.belkin.moon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Belkin on 04.04.2015.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void play(Context c) {
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }

    public void pause() {
        if (mPlayer.isPlaying()) {
            mPlayer.pause();
        } else {
            mPlayer.start();
        }
    }


    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}