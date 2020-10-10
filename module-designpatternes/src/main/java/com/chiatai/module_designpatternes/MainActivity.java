package com.chiatai.module_designpatternes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chiatai.module_designpatternes.chain_of_responsilly.ChainHandler;
import com.chiatai.module_designpatternes.chain_of_responsilly.HandleRequest;
import com.chiatai.module_designpatternes.chain_of_responsilly.HandleResponse;
import com.chiatai.module_designpatternes.chain_of_responsilly.impl.ChainHandlerOne;
import com.chiatai.module_designpatternes.chain_of_responsilly.impl.ChainHandlerThree;
import com.chiatai.module_designpatternes.chain_of_responsilly.impl.ChainHandlerTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private List<HandleRequest> requestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 创建三个处理请求的对象
         */
        final ChainHandler chainHandlerOne = new ChainHandlerOne();
        ChainHandler chainHandlerTwo = new ChainHandlerTwo();
        ChainHandler chainHandlerThree = new ChainHandlerThree();

        /**
         * 形成请求处理链
         */
        chainHandlerOne.setNextChainHandler(chainHandlerTwo);
        chainHandlerTwo.setNextChainHandler(chainHandlerThree);

        /**
         * 创建三个请求
         */
        requestList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            HandleRequest handleRequest = new HandleRequest();
            handleRequest.setHandleLevel(random.nextInt(4));
            requestList.add(handleRequest);
        }


        findViewById(R.id.btnStartRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < requestList.size(); i++) {
                   HandleResponse handleResponse =  chainHandlerOne.handleMessage(requestList.get(i));
                    Log.d(TAG,handleResponse.getResponseMessage());
                }
            }
        });


    }
}
