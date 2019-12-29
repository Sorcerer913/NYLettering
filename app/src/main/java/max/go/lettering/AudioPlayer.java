package max.go.lettering;
import android.content.Context;
import android.media.MediaPlayer;

import java.util.LinkedList;

class AudioPlayer { //TODO: new functions
    public MediaPlayer mPlayer;

    private boolean mix;
    private boolean repeat;
    private LinkedList<Integer> id_music_list;
    private int currentNumber;
    private boolean pauseFlag;

    public AudioPlayer() {
        mix = false;
        repeat = false;
        pauseFlag = false;
        id_music_list = new LinkedList<Integer>();

    }

    public AudioPlayer(LinkedList<Integer> playList) {
        mix = false;
        repeat = false;
        id_music_list = playList;

    }

    public void play(Context context, int id) {
        mPlayer = MediaPlayer.create(context, id);
        currentNumber = id_music_list.indexOf(id);

        final Context contextFinal = context;
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (!repeat) {
                    stop();
                } else {
                    if (currentNumber == id_music_list.size() - 1) {
                        currentNumber++;
                    } else {    //when overflow
                        currentNumber = 0; }

                    play(contextFinal, id_music_list.get(currentNumber));

                }

            }
        });
        mPlayer.start();
    }

    public void release(){
        mPlayer.release();
    }

    public boolean isMixed() {
        return mix;
    }

    public void setMixed(boolean flag) {
        mix = flag;
    }

    public void changeMix() {
        mix = !mix;
    }

    public boolean isRepeat() {
        return repeat;
    }

    public void setRepeat(boolean flag) {
        repeat = flag;
    }

    public void changeRepeat() {
        repeat = !repeat;
    }

    private boolean isPlaying() {
        return mPlayer.isPlaying();
    }

    public boolean isPause(){
        return pauseFlag;
    }

    public void pause() {
        mPlayer.pause();
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

}