package com.dashingqi.module_arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhangqi
 * @time : 11/15/20
 * desc :
 */
public class ArithmeticBackUpFile {

    public int[] one(int[] values, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> maps = new HashMap();
        for (int i = 0; i < values.length; i++) {
            if (maps.containsKey(values[i])) {
                index[0] = maps.get(values[i]);
                index[1] = i;
                return index;
            }

            maps.put(target - values[i], i);
        }
        return index;
    }


}
