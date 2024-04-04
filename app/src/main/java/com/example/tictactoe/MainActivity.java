package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AppCompatButton img1,img2,img3,img4,img5,img6,img7,img8,img9;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    boolean chance = false;

    int flag = 0;
    int count = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        animBlur();
    }


    MediaPlayer clickSound,winmusic,goSound;
    public void clickStart(){
        sounds bgm = new sounds(MainActivity.this);
        bgm.setClickSound(clickSound);
        bgm.getClickSound().start();
    }
    public void winStart(){
        sounds winMusic = new sounds(MainActivity.this);
        winMusic.setWinSound(winmusic);
        winMusic.getWinSound().start();
    }
    public void goverStart(){
        sounds gosound = new sounds(MainActivity.this);
        gosound.setOverSound(goSound);
        gosound.getOverSound().start();
    }



    public void animBlur(){
        ImageView showX = findViewById(R.id.showX);
        ImageView showO = findViewById(R.id.showO);
        if(chance){
            showO.setImageResource(R.drawable.o);
            showX.setImageResource(R.drawable.blurx);
        }else {
            showO.setImageResource(R.drawable.bluro);
            showX.setImageResource(R.drawable.x);
        }
    }

    public void click(View v){
        AppCompatButton currentBtn = (AppCompatButton) v;
        Drawable drawableX = ResourcesCompat.getDrawable(getResources(),R.drawable.x,null);
        Drawable drawableO = ResourcesCompat.getDrawable(getResources(),R.drawable.o,null);
        if(currentBtn.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                clickStart();
                currentBtn.setBackground(drawableX);
                currentBtn.setText("X");
                flag = 1;
                chance = true;
                animBlur();

            } else {
                clickStart();
                currentBtn.setBackground(drawableO);
                currentBtn.setText("O");
                flag = 0;
                chance = false;
                animBlur();

            }
            if (count > 4) {
                b1 = img1.getText().toString();
                b2 = img2.getText().toString();
                b3 = img3.getText().toString();
                b4 = img4.getText().toString();
                b5 = img5.getText().toString();
                b6 = img6.getText().toString();
                b7 = img7.getText().toString();
                b8 = img8.getText().toString();
                b9 = img9.getText().toString();
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {//2
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b1,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {//2
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b4,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b7,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b1,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b2,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b3,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b1,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Win is : "+b3,MainActivity.this,true);
                    dialog.setCancelable(false);
                    dialog.show();
                    winStart();
                } else if (!b1.equals("") && !b2.equals("") && !b3.equals("")
                        && !b4.equals("") && !b5.equals("") && !b6.equals("")
                        && !b7.equals("") && !b8.equals("") && !b9.equals("")) {
                    resultdialog dialog = new resultdialog(MainActivity.this,"Match Tie",MainActivity.this,false);
                    dialog.setCancelable(false);
                    dialog.show();
                    goverStart();
                }
            }
        }
    }



    public void reStart(){
        img1.setBackground(Drawable.createFromPath(" "));
        img2.setBackground(Drawable.createFromPath(" "));
        img3.setBackground(Drawable.createFromPath(" "));
        img4.setBackground(Drawable.createFromPath(" "));
        img5.setBackground(Drawable.createFromPath(" "));
        img6.setBackground(Drawable.createFromPath(" "));
        img7.setBackground(Drawable.createFromPath(" "));
        img8.setBackground(Drawable.createFromPath(" "));
        img9.setBackground(Drawable.createFromPath(" "));

        img1.setText("");
        img2.setText("");
        img3.setText("");
        img4.setText("");
        img5.setText("");
        img6.setText("");
        img7.setText("");
        img8.setText("");
        img9.setText("");
        count = 0;
        flag = 0;

        ImageView showX = findViewById(R.id.showX);
        ImageView showO = findViewById(R.id.showO);
        showX.setImageResource(R.drawable.x);
        showO.setImageResource(R.drawable.bluro);

    }
    public void restartOnClick(View v){
        clickStart();
        RestartDialog restartDialog = new RestartDialog(MainActivity.this,MainActivity.this);
        restartDialog.setCancelable(false);
        restartDialog.show();
    }
    public void Exit(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

//        super.onBackPressed();
    }
}