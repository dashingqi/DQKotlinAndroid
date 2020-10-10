package com.chiatai.module_aop.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author : zhangqi
 * @time : 2020/10/7
 * desc :
 */
@Aspect
public class AppAop {

    private static final String TAG = "AppAop";

    @Around("call(* com.chiatai.module_aop.AopApplication.**(..))")
    public void getAppCostTime(ProceedingJoinPoint proceedingJoinPoint) {
        long time = System.currentTimeMillis();
        String name = proceedingJoinPoint.toShortString();
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log.d(TAG, name + " cost " + (System.currentTimeMillis() - time));
    }
}
