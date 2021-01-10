package com.dashingqi.module.memory;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

/**
 * @author : zhangqi
 * @time : 1/10/21
 * desc :
 */
public class CallbackManager {

    private static List<CallBack> mCallbacks = new ArrayList<>();

    public static void addCallBack(CallBack callBack) {
        mCallbacks.add(callBack);
    }

    public static void removeCallBack(Callback callback) {
        mCallbacks.remove(callback);
    }
}
