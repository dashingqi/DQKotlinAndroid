package com.chiatai.module_java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangqi
 * @time : 1/14/21
 * desc :
 */
class MyTest {


    private void method() {

        List arrays = new ArrayList<String>();
        arrays.add(12);
        arrays.add("");
        Object o = arrays.get(0);

        List<String> arrays1 = new ArrayList<>();
        arrays1.add("12");
        String s = arrays1.get(0);

    }

    public static <T> T method(T filed) {

        return null;
    }
}
