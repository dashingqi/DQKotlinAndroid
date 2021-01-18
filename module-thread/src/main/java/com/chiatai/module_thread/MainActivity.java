package com.chiatai.module_thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static ReentrantReadWriteLock reentrantReadWriteLock;

    private static String number = "0";


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

        reentrantReadWriteLock = new ReentrantReadWriteLock(true);

        Thread t11 = new Thread(new Reader(), "线程1");
        Thread t22 = new Thread(new Reader(), "线程2");
        Thread t33 = new Thread(new Writer(), "线程3");
        t11.start();
        t22.start();
        t33.start();


        //获取IMEI版本号

        findViewById(R.id.find).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imei = getIMEI();
                Log.d("imei == ", imei + "");

            }
        });


    }


    public String getIMEI() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        return deviceId;
        //android 10以上已经获取不了imei了 用 android id代替
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


    /**
     * 读操作
     */
    static class Reader implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 10; i++) {
                reentrantReadWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + "-------> NUmber is " + number);
                reentrantReadWriteLock.readLock().unlock();
            }
        }
    }


    /**
     * 写操作
     */
    static class Writer implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 7; i += 2) {
                try {
                    reentrantReadWriteLock.writeLock().lock();
                    System.out.println(Thread.currentThread().getName() + "正在写入" + i);
                    number = number.concat("" + i);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
        }
    }

}