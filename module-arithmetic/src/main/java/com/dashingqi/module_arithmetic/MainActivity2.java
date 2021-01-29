package com.dashingqi.module_arithmetic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<String> list = new ArrayList<>();
        List list2 = list;
        list2.add("1");
        list2.add(1);
        String res1 = list.get(0);
        String res2 = list.get(1);
    }
}