package com.chiatai.module_viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.chiatai.module_viewbinding.databinding.ActivityMainBinding;

/**
 * ViewBinding 存在的目的就是为了 不用写findViewById()
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        // binding.getRoot()是获取到布局文件中根布局的实例
        setContentView(binding.getRoot());
        binding.tv.setText("您好。。。。");
    }
}
