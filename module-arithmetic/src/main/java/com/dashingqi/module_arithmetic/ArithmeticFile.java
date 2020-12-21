package com.dashingqi.module_arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kotlin.collections.ArraysKt;

/**
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.module_arithmetic
 * @ClassName: ArithmeticFile
 * @Author: DashingQI
 * @CreateDate: 2020/11/12 10:16 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/12 10:16 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ArithmeticFile {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    public static int[] numberOne(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (maps.containsKey(nums[i])) {
                index[0] = i;
                index[1] = maps.get(nums[i]);
                return index;
            }
            maps.put(target - nums[i], i);
        }
        return index;
    }

    /**
     * 整数的反转 采用数学公式的计算
     * 假设我们的环境只能存储得下 32 位的有符号整数，
     * 则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {

            //取到整数的最后一位
            // 5376 ---> 6
            int tempValue = x % 10;

            if (res > 214748364) {
                return 0;
            }

            if (res < -214748364) {
                return 0;
            }
            res = res * 10 + tempValue;

            // 5376 -> 537
            x /= 10;
        }

        return res;
    }


    /**
     * 平衡分割字符串
     * 输入：s = "RLRRLLRLRL"
     * 输出：4
     * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
     */
    public static int balancedSplitStr(String targetStr) {
        //剩余判断的字符串
        String surplusStr = targetStr;
        List splitList = new ArrayList<String>();
        //当剩余未判断的字符串长度大于0
        while (surplusStr.length() > 0) {
            // 拿到剩余未判断的字符串
            surplusStr = balanceSplitUtil(surplusStr)[1];
            //拿到符合条件的字符串 添加到集合中
            splitList.add(balanceSplitUtil(surplusStr)[0]);
        }
        //返回符合条件的切割数
        return splitList.size();

    }

    private static String[] balanceSplitUtil(String surplusStr) {

        String justStr = "";

        for (int i = 1; i < surplusStr.length(); i++) {

            justStr = surplusStr.substring(0, i);
            //分别用于此次字符串中 L和R出现的次数
            int leftNumber = 0, rightNumber = 0;

            for (int j = 0; j < justStr.length(); j++) {
                if (justStr.charAt(j) == 'L') {
                    leftNumber++;
                } else if (justStr.charAt(j) == 'R') {
                    rightNumber++;
                }
            }

            if (leftNumber == rightNumber) {
                //将本次符合条件的字符串和剩余未判断字符串返回回去
                return new String[]{justStr, surplusStr.substring(i)};
            } else {
                continue;
            }

        }
        return new String[]{"", ""};
    }
}
