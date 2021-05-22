package com.example.myapplication131tanometr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    private void pulseSave(){
        Button pulseSaveB = findViewById(R.id.buttonSave1);
        pulseSaveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pulseSave = findViewById(R.id.pulse);
                String pulsik = pulseSave.getText().toString();
                try {                  //     9. Обрабатываем ошибки
                    Pulse pulse = new Pulse(Integer.parseInt(pulsik));

                } catch (Exception ex) {
                      //     Всплывающие ошибки
                }
            }
        });
    }

}