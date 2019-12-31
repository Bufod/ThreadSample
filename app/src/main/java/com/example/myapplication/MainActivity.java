package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView tw;
    Button btDownload, btChangeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tw = (TextView) findViewById(R.id.textView);
        btDownload = (Button) findViewById(R.id.button);
        btDownload.setOnClickListener(download());
        btChangeColor = (Button) findViewById(R.id.button2);
        btChangeColor.setOnClickListener(setRandomColor());
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
    }

    View.OnClickListener download(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler h = new Handler(){
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        tw.setText("Загружено!");
                    }
                };
                MyThread myThread = new MyThread(h);
                myThread.t.start();
            }
        };
    }

    int getRandomColor(){
        int a = (int)(Math.random()*256);
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        return Color.argb(a,r,g,b);
    }

    View.OnClickListener setRandomColor(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.setBackgroundColor(getRandomColor());
            }
        };
    }
}
