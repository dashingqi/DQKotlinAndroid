package com.chiatai.module_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ReentrantLock reentrantLock;
    volatile int index = 0;
    volatile int flag = 1;
    private Condition condition;
    private Condition condition1;
    private Condition condition2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reentrantLock = new ReentrantLock();
        condition = reentrantLock.newCondition();
        condition1 = reentrantLock.newCondition();
        condition2 = reentrantLock.newCondition();


        new Thread(() -> {
            printA();

        }).start();

        new Thread(() -> {
            printB();
        }).start();

        new Thread(() -> {
            printC();
        }).start();

    }


    private void printA() {
        if (index == 100) {
            return;
        }
        try {
            reentrantLock.lock();
            while (flag != 1) {
                condition.await();
            }
            index++;
            Log.d(TAG, "thread name " + Thread.currentThread().getName() + "index == " + index);
            flag = 2;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


    private void printB() {
        if (index == 100) {
            return;
        }
        try {
            reentrantLock.lock();
            while (flag != 2) {
                condition1.await();
            }
            index++;
            Log.d(TAG, "thread name " + Thread.currentThread().getName() + "index == " + index);
            flag = 3;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


    private void printC() {
        if (index == 100) {
            return;
        }
        try {
            reentrantLock.lock();
            while (flag != 3) {
                condition2.await();
            }
            index++;
            Log.d(TAG, "thread name " + Thread.currentThread().getName() + "index == " + index);
            flag = 1;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}