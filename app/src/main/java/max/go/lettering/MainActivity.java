package max.go.lettering;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button button_signOut;
    private Button button_edit_name;

    private Button button_send;
    private Button button_letters_for_you;
    private Button button_music;

    private CheckBox isAnonim;
    private Spinner spinner;
    private Button button_addGroup;
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
        button_edit_name = (Button) findViewById(R.id.button_edit_name);

        button_music = (Button) findViewById(R.id.button_music);
        button_send = (Button) findViewById(R.id.button_send);
        button_letters_for_you = (Button) findViewById(R.id.button_letters_for_you);
        //button_send.setId(View.generateViewId());
        isAnonim = (CheckBox) findViewById(R.id.checkBox);
        spinner = (Spinner) findViewById(R.id.spinner);
        button_addGroup = (Button) findViewById(R.id.button_add_group);
        port = (EditText) findViewById(R.id.edit_text_port);
        pass = (EditText) findViewById(R.id.edit_text_pass);

        button_signOut.setOnClickListener(outClickListener);
        button_edit_name.setOnClickListener(editnameClickListener);
        button_music.setOnClickListener(button_musicClickListener);
        button_send.setOnClickListener(button_sendClickListener);
        button_letters_for_you.setOnClickListener(button_lettersClickListener);
        button_addGroup.setOnClickListener(addgroupClickListener);

        //if(letCheck.isLetterGot())button_letters_for_you.setVisibility(View.VISIBLE);

    }

    View.OnClickListener editnameClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Получаем вид с файла popup_editname.xml, который применим для диалогового окна:
            LayoutInflater li = LayoutInflater.from(MainActivity.this);
            View promptsView = li.inflate(R.layout.popup_editname, null);

            //Создаем AlertDialog
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            //Настраиваем popup_editname.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            final EditText userInput = (EditText) promptsView.findViewById(R.id.input_editname);

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    //Вводим текст и отображаем в строке ввода на основном экране:
                                    //final_text.setText(userInput.getText());

                                    String name = userInput.getText().toString().replaceAll(" ","");

                                    //TODO: Отправка имени в базу данных.

                                    Toast.makeText(MainActivity.this, "Name has changed to \""+name+"\"", Toast.LENGTH_SHORT).show();

                                }
                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

            //Создаем AlertDialog:
            AlertDialog alertDialog = mDialogBuilder.create();

            //и отображаем его:
            alertDialog.show();
        }
    };

    View.OnClickListener addgroupClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Получаем вид с файла popup_editname.xml, который применим для диалогового окна:
            LayoutInflater li = LayoutInflater.from(MainActivity.this);
            View promptsView = li.inflate(R.layout.popup_add_group, null);

            //Создаем AlertDialog
            AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(MainActivity.this);

            //Настраиваем popup_editname.xml для нашего AlertDialog:
            mDialogBuilder.setView(promptsView);

            //Настраиваем отображение поля для ввода текста в открытом диалоге:
            EditText userInput = (EditText) promptsView.findViewById(R.id.input_add_group);

            TextWatcher textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                    //TODO: проверка текста и подсказка, если текст не соответствует требованиям

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };

            userInput.addTextChangedListener(textWatcher);

            //Настраиваем сообщение в диалоговом окне:
            mDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    //Вводим текст и отображаем в строке ввода на основном экране:
                                    //final_text.setText(userInput.getText());

                                    String group_name = userInput.getText().toString().replaceAll(" ","");

                                    //TODO: Создание новой группы, если соответствует требованиям

                                    Toast.makeText(MainActivity.this, "Group \""+group_name+"\" has added!", Toast.LENGTH_SHORT).show();

                                }
                            })
                    .setNegativeButton("Отмена",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int id) {
                                    dialog.cancel();
                                }
                            });

            //Создаем AlertDialog:
            AlertDialog alertDialog = mDialogBuilder.create();

            //и отображаем его:
            alertDialog.show();
        }
    };

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
