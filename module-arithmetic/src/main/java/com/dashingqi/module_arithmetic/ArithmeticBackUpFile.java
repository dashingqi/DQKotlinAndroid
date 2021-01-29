package com.dashingqi.module_arithmetic;

import java.util.ArrayList;
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

    /**
     * "RLRRLLRLRL"
     *
     * @param s
     * @return
     */
    public int balancedStringSplit(String s) {
        ArrayList<String> lists = new ArrayList();


        //用于记录剩下未判断的字符串
        String tempStr = s;
        while (tempStr.length() > 0) {
            tempStr = utils(tempStr)[1];
            lists.add(utils(tempStr)[0]);
        }
        return lists.size();
    }

    public String[] utils(String str) {
        String tempStr = "";
        for (int i = 1; i < str.length(); i++) {
            tempStr = str.substring(0, i);
            int lCount = 0;
            int rCount = 0;
            for (int j = 0; j < tempStr.length(); j++) {
                if (tempStr.charAt(j) == 'L') {
                    lCount++;
                } else if (tempStr.charAt(j) == 'R') {
                    rCount++;
                }
            }
            if (lCount == rCount) {
                return new String[]{tempStr, str.substring(i)};
            } else {
                continue;
            }
        }
        return new String[]{"", ""};
    }

    public static int balancedStringSplit1(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                count++;
            } else if (s.charAt(i) == 'R') {
                count--;
            }
            if (count == 0) {
                res++;
            }
        }
        return res;
    }


    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
