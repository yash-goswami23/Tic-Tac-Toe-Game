package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestartDialog extends Dialog {
    MainActivity mainActivity;
    Button NoBtn,YesBtn;
    MediaPlayer clickSound;

    public RestartDialog(@NonNull Context context,MainActivity mainActivity) {
        super(context);
        this.mainActivity = mainActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restart_dialog);
        NoBtn = findViewById(R.id.noBtn);
        YesBtn = findViewById(R.id.yesBtn);
        NoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             dismiss();
            }
        });
        YesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.reStart();
                dismiss();
            }
        });

    }
}