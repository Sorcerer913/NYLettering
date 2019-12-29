package max.go.lettering;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class LettersActivity extends AppCompatActivity {   //TODO: generator views with massages and scrolling

    private LinearLayout linearLayout;

    private LinkedList<TextView> textViews = new LinkedList<TextView>();

    private int letterNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        letterNumber = 0;

        textViews.add(new TextView(this));
        textViews.get(letterNumber).setText("There are some words to you in this letter...\nIt was generated in onCreate method");
        textViews.get(letterNumber).setWidth(linearLayout.getWidth());
        textViews.get(letterNumber).setId(letterNumber);
//        textViews.get(letterNumber).setBackground(R.color.textBackground);  //TODO: background

        linearLayout.addView(textViews.get(0));


        //scrollView.getChildAt(0);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LettersActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
