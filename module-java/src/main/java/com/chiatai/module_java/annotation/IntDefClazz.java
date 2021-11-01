package com.chiatai.module_java.annotation;

import android.util.Log;

/**
 * @author zhangqi61
 * @since 2021/10/13
 */
public class IntDefClazz {

    @TagCheck public static final int TAG_ONE = 1;

    @TagCheck public static final int TAG_TWO = 2;

    public static void printTag(@TagCheck int tag) {
        Log.d("IntDef", "" + tag);
    }
}
