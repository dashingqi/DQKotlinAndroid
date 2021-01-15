package com.chiatai.module_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        Thread t3 = new Thread(myRunnable);
        t1.start();
        t2.start();
        t3.start();

    }


    class MyRunnable implements Runnable {
        int index = 0;
        ReentrantLock reentrantLock = new ReentrantLock(true);

        @Override
        public void run() {
            while (index < 100) {
                reentrantLock.lock();
                try {
                    Log.d("=========", Thread.currentThread().getName() + " === index == " + index);
                    index++;

                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }
}