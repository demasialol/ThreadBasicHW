package com.androidapp.threadbasic0603;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Thread wr;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @Override
        protected  void onStart(){
            super.onStart();
            running = true;
            wr = new Thread(new Runnable(){
                @Override
                        public void run(){
                    int i = 0;
                    for (i = 0; i < 20 && running; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        Log.v(TAG, "Thread time=" + i);
                }
            }
    });
            wr.start();
            Log.v(TAG, "Now I am onStart");


}