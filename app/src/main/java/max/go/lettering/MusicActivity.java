package max.go.lettering;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MusicActivity extends AppCompatActivity {  //TODO: nice layout with new buttons

    private ImageButton button_play_pause;
    private ImageButton button_forwards;
    private ImageButton button_backward;
    private Button button_change_music;

    private AudioPlayer mPlayer;
    private int currentMediaID;
    private boolean a = true;

    View.OnClickListener buttonPlayPauseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            mPlayer.stop();
            if (a) {    //Play
                //mPlayer.play(getApplicationContext(), R.raw.letitsnow)
                if(mPlayer.isPause()){
                    mPlayer.release();
                }else {
                    mPlayer.play(MusicActivity.this, currentMediaID);
                }
                button_play_pause.setImageResource(R.drawable.pause);

                a = false;
            } else {    //Pause
                mPlayer.pause();
                button_play_pause.setImageResource(R.drawable.play/*R.drawable.ic_button_pause*/);

                a = true;
            }
        }
    };

    View.OnClickListener buttonStopClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPlayer.stop();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        currentMediaID = R.raw.letitsnow;

        button_play_pause = (ImageButton) findViewById(R.id.button_play_pause);
        button_forwards = (ImageButton) findViewById(R.id.button_forwards);
        button_backward = (ImageButton) findViewById(R.id.button_backward);
        button_change_music = (Button) findViewById(R.id.button_change_music);

        button_play_pause.setOnClickListener(buttonPlayPauseClickListener);
        //button_play_pause.

        mPlayer = new AudioPlayer();

        //button1.setVisibility(View.VISIBLE);
        /*{
            button1.setPadding(//...);
        }*/


    }

   /*View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    };*/


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MusicActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        super.onDestroy();
    }

}

