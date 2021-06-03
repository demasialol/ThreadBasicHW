package com.androidapp.threadbasic0603;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    WorkerThread wt;
    WorkerRunnable wr;
    boolean running = true;

    String TAG = "Thread";

    class WorkerThread extends Thread {
        public void run() {
            int i=0;
            for (i=0; i<20 && running; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                Log.v(TAG, "Thread time " + i);
            }
        }
    }
    class WorkerRunnable extends Thread {
        public void run() {
            int i = 0;
            for(i=0; i<20 && running; i++) {
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                }
                Log.v(TAG, "Runnable time " + i);
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Now I am in onCreate");
    }


    @Override
    public void onStart(){
        super.onStart();
        running = true;
        wr = new WorkerRunnable();
        wr.run();
        wt = new WorkerThread();
        wt.start();
        Log.v(TAG,"Now I am in onstart");
    }

    @Override
    public void onStop(){
        super.onStop();
        running = false;
        Log.v(TAG,"Now I am in onStop");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.v(TAG,"Now I am in onPause");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.v(TAG,"Now I am in onResume");
    }
}

