package com.example.fatherfamily;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Time;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.media.MediaPlayer;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random random = new Random();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //define buttons
        Button botao = findViewById(R.id.butao);
        Button botao2 = findViewById(R.id.buttao);

        //10:01 = 601000
        //15:40 = 924000
        //
        int vamove = R.raw.audio;
        int time = 4000;
        botao.setOnClickListener(v -> {
            if (player == null) {
                player = MediaPlayer.create(this, vamove);
            }
            defineTimePlaying(time, player);
        });
        botao2.setOnClickListener(v -> {
            if (player != null) {

                if (!player.isPlaying()) {
                    Toast.makeText(getApplicationContext(), "Não há áudio tocando", Toast.LENGTH_SHORT).show();
                } else {
                    player.pause();
                }
            } else {
                Toast.makeText(getApplicationContext(), "PLAYER NULO", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //usar tempos em SEGUNDOS
    public void defineTimePlaying(int time, MediaPlayer player) {
        Random random = new Random();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                player.pause();
            }
        };
        int tempo = time;
        int aleatorio = random.nextInt(1500000);

        if (aleatorio > 0 && aleatorio <= 1500000) {
            Log.d("(if)VALOR DE ALEATORIO: ", "" + aleatorio);
            player.start();
            player.seekTo(aleatorio);
            timer.schedule(timerTask, 3000);

        } else {
            Log.d("(else)VALOR DE ALEATORIO: ", "" + aleatorio);
            Toast.makeText(getApplicationContext(), "Aperta dnv", Toast.LENGTH_SHORT).show();
        }
    }
}