package com.example.myapplication;

import android.os.Handler;
import android.util.Log;


public class MyThread implements Runnable {
    Handler h;
    Thread t;

    public MyThread(Handler h) {
        this.h = h;
        this.t = new Thread(this);
    }

    @Override
    public void run() {
        imitationDownload();
        h.sendEmptyMessage(0);
    }

    void imitationDownload(){
        int n = 100;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Log.i("imitationDownload", Integer.toString(i*j));
    }
}
