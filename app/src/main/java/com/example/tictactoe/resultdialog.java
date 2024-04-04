package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class resultdialog extends Dialog {
    private final String message;
    private  final MainActivity mainActivity;
    private final boolean wt;
    LottieAnimationView MainAinm;
    public resultdialog(@NonNull Context context,String message,MainActivity mainActivity,boolean wt) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
        this.wt = wt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultdialog);
        TextView messageText = findViewById(R.id.messagetext);
        Button startAgainButton = findViewById(R.id.startAgainButton);
        Button exit = findViewById(R.id.BackButton);
        messageText.setText(message);
        MainAinm = findViewById(R.id.mainAinm);
        if(wt){
            MainAinm.setAnimation(R.raw.winning);
        }else {
            MainAinm.setAnimation(R.raw.gameover);
        }
        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.reStart();
                dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.Exit();
            }
        });
    }
}