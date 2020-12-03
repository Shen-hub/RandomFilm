package com.example.randomfilm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    String[] films;
    List<String> usedFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.film);
        films = getResources().getStringArray(R.array.films);
        usedFilms = new ArrayList<>();
    }

    public void randomFilm(View v) {
        String randomStr = films[new Random().nextInt(films.length)];
        while (usedFilms.contains(randomStr))
        {
            randomStr = films[new Random().nextInt(films.length)];
            if (usedFilms.size() >= films.length) break;
        }

        if (usedFilms.size() < films.length)
        {
            usedFilms.add(randomStr);
            tv.setText(randomStr);
        }
        else {
            tv.setText("Фильмы закончились, нажмите кнопку сброса.");
        }
    }
    public void reset(View V){
        tv.setText("Нажмите на кнопку, чтобы сгенерировать фильм.");
        usedFilms.clear();
    }
}
