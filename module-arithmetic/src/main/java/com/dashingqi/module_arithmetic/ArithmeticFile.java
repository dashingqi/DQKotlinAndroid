package com.dashingqi.module_arithmetic;

import java.util.ArrayList;
import java.util.Arrays;
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


    /**
     * 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
     * 输入: "Hello"
     * 输出: "hello"
     * 输入: "here"
     * 输出: "here"
     */
    public static String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char tempC = str.charAt(i);
            if (tempC >= 'A' && tempC <= 'Z') {
                tempC += 32;
            }
            sb.append(tempC);
        }
        return sb.toString();
    }


    /**
     * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
     * 输入："Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        //切割字符串
        String[] tempStrArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder tempSb = new StringBuilder();
        //将子字符串进行反转
        for (int i = 0; i < tempStrArray.length; i++) {
            tempSb.delete(0, tempSb.length());
            sb.append(tempSb.append(tempStrArray[i]).reverse().toString());
            if (i < tempStrArray.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * <p>
     * 输入: s1 = "abc", s2 = "bca"
     * 输出: true
     * <p>
     * 输入: s1 = "abc", s2 = "bad"
     * 输出: false
     * 1. 首先判断 s1和s2的长度是否相等
     * 2. 然后匹配s2中每一个字符串
     */

    public static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        String tempStr = s2;

        for (int i = 0; i < s1.length(); i++) {
            int tempIndex = tempStr.indexOf(s1.charAt(i));
            if (tempIndex == -1) {
                return false;
            } else {
                tempStr = deleteCharByIndex(tempStr, tempIndex);
            }
        }

        return true;
    }

    private static String deleteCharByIndex(String tempStr, int index) {
        return tempStr.substring(0, index) + tempStr.substring(index + 1);
    }

    /**
     * 贪心算法
     * 非升序排列的总列数
     *
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        int result = 0;
        int length = A[0].length();
        // i表示列数
        for (int i = 0; i < length; i++) {
            //j 表示行数
            for (int j = 0; j < A.length; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
     *
     * 如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
     *
     * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
     *
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {

        List<Integer> resultList = new ArrayList<>();
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
        }
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            count += nums[i];
            resultList.add(nums[i]);
            if (count > (sum - count)) {
                return resultList;
            }
        }
        return null;

    }
}
