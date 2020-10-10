package com.chiatai.module_aop;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;

/**
 * @author : zhangqi
 * @time : 2020/10/7
 * desc :
 */
public class AopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initFresco();
        initUmeng();
    }

    /**
     * 初始化友盟
     */
    private void initUmeng() {
        UMConfigure.init(this, null, "aop_um", 0, "");
    }

    /**
     * 初始化Fresco
     */
    private void initFresco() {
        Fresco.initialize(this);
    }
}
