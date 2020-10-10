package com.dashingqi.module.startup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.dashingqi.module.startup.record.LaunchTimer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView feedRv = findViewById(R.id.feedRV);
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Person person = new Person();
            person.setName("name" + i);
            mData.add(person);
        }
        MyAdapter myAdapter = new MyAdapter(mData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        feedRv.setLayoutManager(linearLayoutManager);
        feedRv.setAdapter(myAdapter);
    }


    /**
     * 只是首帧的回调
     *
     * @param hasFocus
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            LaunchTimer.endRecord("onWindowFocusChanged");
    }
}
