package com.example.fatherfamily;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //buttons
        Button botao = findViewById(R.id.butao);
        Button botao2 = findViewById(R.id.buttao);

        int vamove = R.raw.audio;

        botao.setOnClickListener(v -> {
            if (player == null) {
                player = MediaPlayer.create(this, vamove);
            }
            defineTimePlaying(player);
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


    public void defineTimePlaying(MediaPlayer player) {
        Random random = new Random();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                player.pause();
            }
        };

        int time = player.getDuration();
        int aleatorio = random.nextInt(time);
        SimpleDateFormat sf = new SimpleDateFormat("mm:ss");
        TextView tempo = findViewById(R.id.valorTempo);
        if (aleatorio > 0 && aleatorio <= time) {
            Log.d("(if)VALOR DE ALEATORIO: ", "" + aleatorio);
            player.start();
            player.seekTo(aleatorio);
            tempo.setText("TEMPO: " + sf.format(aleatorio));
            timer.schedule(timerTask, 3000);
        } else {
            Log.d("(else)VALOR DE ALEATORIO: ", "" + aleatorio);
            Toast.makeText(getApplicationContext(), "Aperta dnv", Toast.LENGTH_SHORT).show();
        }
    }
}