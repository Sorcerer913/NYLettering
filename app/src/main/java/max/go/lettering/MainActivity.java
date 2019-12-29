package max.go.lettering;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button button_signOut;

    private Button button_send;
    private Button button_letters_for_you;
    private Button button_music;

    private CheckBox isAnonim;
    private Spinner spinner;
    private EditText port;
    private EditText pass;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        button_signOut = (Button) findViewById(R.id.button_signout);

        button_music = (Button) findViewById(R.id.button_music);
        button_send = (Button) findViewById(R.id.button_send);
        button_letters_for_you = (Button) findViewById(R.id.button_letters_for_you);
        //button_send.setId(View.generateViewId());
        isAnonim = (CheckBox) findViewById(R.id.checkBox);
        spinner = (Spinner) findViewById(R.id.spinner);
        port = (EditText) findViewById(R.id.edit_text_port);
        pass = (EditText) findViewById(R.id.edit_text_pass);

        button_signOut.setOnClickListener(outClickListener);
        button_music.setOnClickListener(button_musicClickListener);
        button_send.setOnClickListener(button_sendClickListener);
        button_letters_for_you.setOnClickListener(button_lettersClickListener);

        //if(letCheck.isLetterGot())button_letters_for_you.setVisibility(View.VISIBLE);

    }

    View.OnClickListener outClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mAuth.signOut();
            Intent intent = new Intent(MainActivity.this, EmailPasswordActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener button_lettersClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LettersActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener button_sendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.super.getApplicationContext(), "Letter has sent", Toast.LENGTH_SHORT).show();

            //...

        }
    };

    View.OnClickListener button_musicClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MusicActivity.class);
            startActivity(intent);
        }
    };

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
