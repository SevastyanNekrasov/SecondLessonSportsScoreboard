package com.msaggik.secondlessonsportsscoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // поля
    private TextView score; // табло бля вывода счёта игры
    private Button lionsTeam, panthersTeam; // кнопки команд
    private int countLions = 0, countPanthers = 0; // счётчики счёта команд

    // создание активности
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка разметки к полям
        score = findViewById(R.id.score);
        lionsTeam = findViewById(R.id.lionsTeam);
        panthersTeam = findViewById(R.id.panthersTeam);

        // обработка нажатия кнопок
        lionsTeam.setOnClickListener(listener);
        panthersTeam.setOnClickListener(listener);
    }

    // метод сохранения данных
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lions", countLions); // сохранение данных очков команды львов
        outState.putInt("panthers", countPanthers); // сохранение данных очков команды пантер
    }

    // метод извлечения данных при создании активности
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countLions = savedInstanceState.getInt("lions"); // сохранение данных очков команды львов
        countPanthers = savedInstanceState.getInt("panthers"); // сохранение данных очков команды пантер
        // вывод данных на экран смартфона
        score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
    }

    // обпределение слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // обработка счётчиков
            switch (view.getId()) {
                case R.id.lionsTeam:
                    countLions++;
                    break;
                case R.id.panthersTeam:
                    countPanthers++;
                    break;
            }
            // вывод данных на экран смартфона
            score.setText(String.format("%02d", countLions) + " : " + String.format("%02d", countPanthers));
        }
    };
}