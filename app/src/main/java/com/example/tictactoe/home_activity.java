package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home_activity extends AppCompatActivity {
    Button mltiplyr,playAI;
    MediaPlayer bgmsound;
    sounds bgm;
    public void bgmStart(){
        bgm = new sounds(home_activity.this);
        bgm.setBgSound(bgmsound);
        bgm.getBgSound().start();
        bgm.getBgSound().setLooping(true);
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mltiplyr = findViewById(R.id.singlePlayer);
        playAI = findViewById(R.id.playAi);
        bgmStart();

        mltiplyr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        playAI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}