package com.example.fatherfamily;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import java.net.HttpCookie;
import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public MediaPlayer player;
    @SuppressLint("MissingInflatedId")
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
        Button botao = findViewById(R.id.butao);

        List<String> lista = new ArrayList<>();

        lista.add("teste1");
        int vamove = R.raw.audio;
        Random random = new Random();
        if(!lista.isEmpty()){
            Log.d("OLHA AI", "opa");
        }

        botao.setOnClickListener(v -> {
             Toast.makeText(getApplicationContext(), "JayPlays", Toast.LENGTH_SHORT).show();
            if(player == null){
                player = MediaPlayer.create(this,vamove);
            }
            player.start();

            int duracao = player.getDuration();
            float duracaoSeg = (float) duracao / 1000;

            Log.d("LEIA AQUI:", String.valueOf(duracaoSeg));
            player.seekTo(random.nextInt());


        });
    }
}