package com.example.myapplication131tanometr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    final String TAG = "MyLog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        buttonSave();
    }

    private void buttonSave() { //     1. Метод действия кнопки
        Button butSave = findViewById(R.id.buttonSave1); //     2. Создаем ссылку на созданную кнопку
        butSave.setOnClickListener(new View.OnClickListener() { //      3. Создали слушителя нажатия на кнопку
            @Override
            public void onClick(View v) { //     4. Анонимный метод нажатия на кнопку
                EditText volHigSav = findViewById(R.id.volumehight); //     5. Создаем ссылку на элемент в котором вписываем высокое давление
                String volHigSavValue = volHigSav.getText().toString();  //     6.
                EditText volLowSav = findViewById(R.id.volumelow); //     7. Создаем ссылку на элемент в котором вписываем низкое давление
                String volLowSavValue = volLowSav.getText().toString(); //     8.
                Log.d(TAG, "НАЖАТА КНОПКА СОХРАНИТЬ");
                try {                  //     9. Обрабатываем ошибки
                    Volume volume = new Volume(Integer.parseInt(volHigSavValue), Integer.parseInt(volLowSavValue));
                    SharedPreferences settings = getSharedPreferences("HightVolume", MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putString( "name", "John" );

                    editor.commit();
                } catch (Exception ex) {
                    Toast.makeText(MainActivity2.this, "Не верный формат ввода", Toast.LENGTH_LONG).show();  //     Всплывающие ошибки
                }
            }

        });
    }
}

//if (volHigSavValue.equals("")) {
//        Toast.makeText(MainActivity2.this, " Заполните данные - Высокое давление", Toast.LENGTH_LONG).show();
//        System.out.println(" Заполните данные - Высокое давление");
//        }



