package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
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

    void imitationDownload(){
        int n = 1000;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Log.i("imitationDownload", Integer.toString(i*j));
    }
    View.OnClickListener download(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imitationDownload();
                tw.setText("Загружено!");
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
