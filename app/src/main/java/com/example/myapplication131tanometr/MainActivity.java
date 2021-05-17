package com.example.myapplication131tanometr;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class MainActivity extends AppCompatActivity {
    FileOutputStream outputStream;  // предназначен для записи байтов в файл
    InputStreamReader inputStreamReader;  // записывает текст в поток
    final String TAG ="MyLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"ЗАГРУЖЕН ОСНОВНОЙ ЭКРАН");
        volumeButton();
        pulseButton();
        TextView text = findViewById(R.id.autor);
        EditText editSurname = findViewById(R.id.surname);
        EditText editName = findViewById(R.id.name);
        EditText editLastname = findViewById(R.id.lastname);
        Button save = findViewById(R.id.buttonSave1);
        Button read = findViewById(R.id.buttonRead);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = editSurname.getText().toString();
                String text = editSurname.getText().toString() + " " + editName.getText().toString() + " " + editLastname.getText().toString();;
                Log.d("MyLog", filename);
                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(text.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                editSurname.setText("");
                editName.setText("");
                editLastname.setText("");
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String filename = editSurname.getText().toString();
                    inputStreamReader = new InputStreamReader(openFileInput(filename));
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String line = reader.readLine();
                    Toast.makeText(MainActivity.this,line,Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //if (volHigSavValue.equals("")) {
//        Toast.makeText(MainActivity2.this, " Заполните данные - Высокое давление", Toast.LENGTH_LONG).show();
//        System.out.println(" Заполните данные - Высокое давление");
//        }

    private void volumeButton(){ //     1. Метод действия кнопки
        Button volumeBut = findViewById(R.id.buttonVolume); //     2. Создаем ссылку на созданную кнопку
        volumeBut.setOnClickListener(new View.OnClickListener() { //      3. Создали слушителя нажатия на кнопку
            @Override
            public void onClick(View v) { //     4. Анонимный метод нажатия на кнопку
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                Log.d(TAG,"ПЕРЕКЛЮЧАЕТСЯ НА ЭКРАН ДАВЛЕНИЯ");
            }
        });
    }

    private void pulseButton(){ //     1. Метод действия кнопки
        Button pulseBut = findViewById(R.id.buttonPulse); //     2. Создаем ссылку на созданную кнопку
        pulseBut.setOnClickListener(new View.OnClickListener() { //      3. Создали слушителя нажатия на кнопку
            @Override
            public void onClick(View v) { //     4. Анонимный метод нажатия на кнопку
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                Log.d(TAG,"ПЕРЕКЛЮЧАЕТСЯ НА ЭКРАН ПУЛЬСА");
            }
        });
    }
}